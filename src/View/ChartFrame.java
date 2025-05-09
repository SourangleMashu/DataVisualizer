package View;

/*
 * This class creates a JFrame to display a bar chart 
 * and a button to download the chart as an image.
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;

import Application.Application;

public class ChartFrame extends JFrame {

    // Constructor
    public ChartFrame() {
        init();
    }

    private void init() {

        // Create a bar chart
        JFreeChart chart = ChartFactory.createBarChart(
                "Bar Chart", // Chart title
                DataChooser.column1, // X-axis label
                DataChooser.column2, // Y-axis label
                Application.dataset // Dataset
        );

        // Create a JFrame to display the chart
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);

        // Create a ChartPanel and add the chart to it
        ChartPanel chartPanel = new ChartPanel(chart);

        // Add the chart panel to the frame
        add(chartPanel, BorderLayout.CENTER);

        // Create a download chart button
        JButton downloadButton = new JButton("Download Chart");
        downloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                File imageFile = new File("BarChart.jpeg");

                try {
                    ChartUtils.saveChartAsJPEG(imageFile, chart, 800, 600);
                    System.out.println("Chart saved as image.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        // Add the download button to the frame
        add(downloadButton, BorderLayout.SOUTH);
    }
}