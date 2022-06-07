package org.knowm.xchart;

import org.junit.Test;

import java.util.Random;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class HeatMapTest {
    /*
    *Purpose : Check for Width, Height, Title
    * Input: build() with width(1000), height(600), title("Bound Test")
    * Expected: getWidth() -> 1000, getHeight -> 600, getTitle -> "Bound Test"
     */
    @Test
    public void BoundTest() {

        HeatMapChart chart = new HeatMapChartBuilder().width(1000).height(600).title("Bound Test").build();
        assertEquals(1000,chart.getWidth());
        assertEquals(600, chart.getHeight());
        assertEquals("Bound Test",chart.getTitle());
    }
    /*
     *Purpose : Check for AddSeries
     * Input: addSeries(xData,yData,heatData) // these are 12 random heatMap data by x in [1,4] and y in [1,3]
     * Expected:
     * getSeriesMap().size() -> 1
     * getSeriesMap().get("Basic HeatMap").heatData.size() == 12
     */
    @Test
    public void AddSeriesTest() {
        HeatMapChart chart = new HeatMapChartBuilder().width(1000).height(600).title("Bound Test").build();
        int[] xData = {1, 2, 3, 4};
        int[] yData = {1, 2, 3};
        int[][] heatData = new int[xData.length][yData.length];
        Random random = new Random();
        for (int i = 0; i < xData.length; i++) {
            for (int j = 0; j < yData.length; j++) {
                heatData[i][j] = random.nextInt(1000);
            }
        }
        chart.addSeries("Basic HeatMap", xData, yData, heatData);

        assertEquals(1,chart.getSeriesMap().size());
        assertEquals(12, chart.getSeriesMap().get("Basic HeatMap").heatData.size());
    }
    /*
     *Purpose : Check for large heat data
     * Input: addSeries(xData,yData,heatData) // these are 1000000 random heatMap data by x in [1,10000] and y in [1,10000]
     * Expected:
     * getSeriesMap().size() -> 1
     * getSeriesMap().get("Basic HeatMap").heatData.size() == 1000000
     */
    @Test
    public void BigHeatdataTest(){
        HeatMapChart chart = new HeatMapChartBuilder().width(1000).height(600).title("Bound Test").build();
        int[] xData = new int[1000];
        int[] yData = new int[1000];
        int[][] heatData = new int[xData.length][yData.length];
        Random random = new Random();
        for (int i = 0; i < xData.length; i++){
            xData[i] = i+1;
            yData[i] = i+1;
        }
        for (int i = 0; i < xData.length; i++) {
            for (int j = 0; j < yData.length; j++) {
                heatData[i][j] = random.nextInt(1000);
            }
        }
        chart.addSeries("Basic HeatMap", xData, yData, heatData);

        assertEquals(1, chart.getSeriesMap().size());
        assertEquals(1000000,chart.getSeriesMap().get("Basic HeatMap").heatData.size());
    }
    /*
     *Purpose : Check for Default HeatMapChartBuilder build()
     * Input: chart build without call width(),height(),title() method
     * Expected: getWidth() -> 800, getHeight -> 600, getTitle -> ""
     */
    @Test
    public void DefaultBuildTest(){
        HeatMapChart chart = new HeatMapChartBuilder().build();
        assertEquals(800,chart.getWidth());
        assertEquals(600, chart.getHeight());
        assertEquals("",chart.getTitle());

    }
}
