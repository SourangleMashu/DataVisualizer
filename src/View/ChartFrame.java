package View;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

import org.jfree.chart.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;

import Application.Application;

public class ChartFrame extends JFrame {

    private JComboBox<String> chartTypeComboBox;
    private ChartPanel chartPanel;
    private JFreeChart chart;

    public ChartFrame() {
        init();
    }

    private void init() {
        setTitle("Chart Viewer");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Chart type combo box
        String[] chartTypes = {"Bar Chart", "Line Chart", "Area Chart"};
        chartTypeComboBox = new JComboBox<>(chartTypes);
        chartTypeComboBox.addActionListener(e -> updateChart());

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(new JLabel("Chart Type:"));
        topPanel.add(chartTypeComboBox);
        add(topPanel, BorderLayout.NORTH);

        // Create initial chart and panel
        chart = createChart("Bar Chart");
        chartPanel = new ChartPanel(chart);
        add(chartPanel, BorderLayout.CENTER);

        // Download button
        JButton downloadButton = new JButton("Download Chart");
        downloadButton.addActionListener(e -> {
            try {
                ChartUtils.saveChartAsJPEG(new File("Chart.jpeg"), chart, 800, 600);
                System.out.println("Chart saved.");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        add(downloadButton, BorderLayout.SOUTH);
    }

    private void updateChart() {
        String selectedType = (String) chartTypeComboBox.getSelectedItem();
        chart = createChart(selectedType);
        remove(chartPanel);
        chartPanel = new ChartPanel(chart);
        add(chartPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private JFreeChart createChart(String type) {
        String title = type;
        String xLabel = DataChooser.column1;
        String yLabel = DataChooser.column2;
        DefaultCategoryDataset dataset = Application.dataset;

        JFreeChart chart;

        switch (type) {
            case "Line Chart":
                chart = ChartFactory.createLineChart(title, xLabel, yLabel, dataset);
                break;
            case "Area Chart":
                chart = ChartFactory.createAreaChart(title, xLabel, yLabel, dataset);
                break;
            default:
                chart = ChartFactory.createBarChart(title, xLabel, yLabel, dataset);
                break;
        }

        // Style chart and plot
        chart.setBackgroundPaint(Color.WHITE);
        chart.getTitle().setFont(new Font("SansSerif", Font.BOLD, 18));

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinePaint(Color.GRAY);
        plot.setRangeGridlinePaint(Color.GRAY);
        plot.setOutlineVisible(false);

        plot.getDomainAxis().setLabelFont(new Font("SansSerif", Font.BOLD, 14));
        plot.getDomainAxis().setTickLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.getRangeAxis().setLabelFont(new Font("SansSerif", Font.BOLD, 14));
        plot.getRangeAxis().setTickLabelFont(new Font("SansSerif", Font.PLAIN, 12));

        if (plot.getRenderer() instanceof BarRenderer) {
            BarRenderer renderer = (BarRenderer) plot.getRenderer();
            renderer.setDrawBarOutline(false);
            renderer.setBarPainter(new StandardBarPainter());
            renderer.setSeriesPaint(0, new Color(79, 129, 189));
            renderer.setItemMargin(0.05);
        }

        return chart;
    }
}
