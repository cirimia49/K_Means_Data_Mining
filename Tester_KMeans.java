// Test driver for the KMeans class


import java.io.*;
import java.util.Arrays;

public class Tester_KMeans {
    public static void main(String[] args){
       
        KMeans KM3 = new KMeans();
        double[][] centroids = null;
        double[][] data = null;
        double[][] myMatrix = null;
        int[] clusters = null;
        int[] initCentroidIndices = null;
        double SSE = 0.0;
        int index = 0, k = 0;
        int numPassedTests = 0;
        int numTotalTests = 0;
        String testResult;
        
        double[][] iris = loadMatrix("iris.txt", 150, 4);
        
        // Test 1
        numTotalTests++;
        int[] irReturn = null;
        testResult = "[Failed]";
        String eMsg = "N/A";
        try {
            k = 2;
            int[] centroidIndices = {15, 80};
            double[][] testData = {
                {4.5, 1.8, 3.2, 1.1},
                {5.2, 4.1, 1.5, 0.1}
                }; 
            data = testData;
            
            int[] expectedClusters = {1, 0};
            clusters = expectedClusters;
            
            centroids = initializeCentroids(centroidIndices, iris);
            irReturn = KM3.assignSamples(k, centroids, data);
                        
            if (compareClusters(expectedClusters, irReturn)){
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e){
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }

        System.out.println("Test " + numTotalTests + ": assignSamples - " + testResult);
        printMatrix(centroids, "Centroids");
        System.out.println();       
        printMatrix(data, "Test records");
        
        System.out.print(" --------------\n Expected:");
        System.out.println(Arrays.toString(clusters));
        
        if (eMsg.equals("N/A")){
            System.out.print(" Yours: ");
            System.out.println(Arrays.toString(irReturn));
            System.out.println();
        }
        else
            System.out.println(" Yours: " + eMsg + "\n");
        
        // Test 2
        numTotalTests++;
        irReturn = null;
        testResult = "[Failed]";
        eMsg = "N/A";
        try{
            k = 2;
            int[] centroidIndices = {15, 80};
            double[][] testData = {
                {5.8, 2, 3, 0.2},
                {5.2, 4.1, 1.5, 0.1},
                {5.9, 4.2, 1.2, 1.5},
                {5.4, 3, 4.5, 1.5} 
                }; 
            data = testData;
            
            int[] expectedClusters = {1, 0, 0, 1};
            clusters = expectedClusters;
            
            centroids = initializeCentroids(centroidIndices, iris);
            irReturn = KM3.assignSamples(k, centroids, data);
                        
            if (compareClusters(expectedClusters, irReturn)){
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e){
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }

        System.out.println("Test " + numTotalTests + ": assignSamples - " + testResult);
        printMatrix(centroids, "Centroids");
        System.out.println();        
        printMatrix(data, "Test records");
        
        System.out.print(" --------------\n Expected:");
        System.out.println(Arrays.toString(clusters));
        
        if (eMsg.equals("N/A")){
            System.out.print(" Yours: ");
            System.out.println(Arrays.toString(irReturn));
            System.out.println();
        }
        else
            System.out.println(" Yours: " + eMsg + "\n");  
        
        // Test 3
        numTotalTests++;
        irReturn = null;
        testResult = "[Failed]";
        eMsg = "N/A";
        try{
            k = 3;
            int[] centroidIndices = {26, 83, 116};
            double[][] testData = {
                {5.0, 3.7, 1.0, 1.8},
                {5.9, 3.2 ,4.8, 1.8},
                {6.1, 3, 4.6, 1.4},
                {6.7, 3.1, 5.6, 2.4} 
                }; 
            data = testData;
            
            int[] expectedClusters = {0, 1, 1, 2};
            clusters = expectedClusters;
            
            centroids = initializeCentroids(centroidIndices, iris);
            irReturn = KM3.assignSamples(k, centroids, data);
                        
            if (compareClusters(expectedClusters, irReturn)) {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e) {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }

        System.out.println("Test " + numTotalTests + ": assignSamples - " + testResult);
        printMatrix(centroids, "Centroids");
        System.out.println();        
        printMatrix(data, "Test records");
        
        System.out.print(" --------------\n Expected:");
        System.out.println(Arrays.toString(clusters));
        
        if (eMsg.equals("N/A")) {
            System.out.print(" Yours: ");
            System.out.println(Arrays.toString(irReturn));
            System.out.println();
        }
        else
            System.out.println(" Yours: " + eMsg + "\n");

        // Test 4
        numTotalTests++;
        double[][] drReturn = null;
        testResult = "[Failed]";
        eMsg = "N/A";
        try {
            k = 2;
            double[][] testData = {
                {4.5, 1.8, 3.2, 1.1},
                {5.2, 4.1, 1.5, 0.1}
                }; 
            data = testData;

            int[] myArray = {1, 0};
            clusters = myArray;
            drReturn = KM3.updateCentroids(k, clusters, data);
            
            double[][] expectedCentroids = {
                {5.2, 4.1, 1.5, 0.1},
                {4.5, 1.8, 3.2, 1.1}
                }; 
            myMatrix = expectedCentroids;
                        
            if (compareCentroids(expectedCentroids, drReturn)){
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e) {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }

        System.out.println("Test " + numTotalTests + ": updateCentroids - " + testResult);
        printMatrix(data, "Test records");
        System.out.println();        
        System.out.println("   Clusters: " + Arrays.toString(clusters));
        
        System.out.println(" --------------\n Expected:");
        printMatrix(myMatrix, "Centroids");
        System.out.println();
        
        if (eMsg.equals("N/A")){
            System.out.println(" Yours: ");
            printMatrix(drReturn, "Centroids");
            System.out.println();
        }
        else
            System.out.println(" Yours: " + eMsg + "\n");  
        
        // Test 5
        numTotalTests++;
        drReturn = null;
        testResult = "[Failed]";
        eMsg = "N/A";
        try{
            k = 3;
            double[][] testData = {
                {5.8, 2, 3, 0.2},
                {5.2, 4.1, 1.5, 0.1},
                {5.9, 4.2, 1.2, 1.5},
                {5.4, 3, 4.5, 1.5}
                }; 
            data = testData;

            int[] myArray = {0, 1, 1, 2};
            clusters = myArray;
            drReturn = KM3.updateCentroids(k, clusters, data);
            
            double[][] expectedCentroids = {
                {5.80, 2.00, 3.00, 0.20},	
                {5.55, 4.15, 1.35, 0.80},	
                {5.40, 3.00, 4.50, 1.50}
                }; 
            myMatrix = expectedCentroids;
                        
            if (compareCentroids(expectedCentroids, drReturn)){
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e){
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }

        System.out.println("Test " + numTotalTests + ": updateCentroids - " + testResult);
        printMatrix(data, "Test records");
        System.out.println();        
        System.out.println("   Clusters: " + Arrays.toString(clusters));
        
        System.out.println(" --------------\n Expected:");
        printMatrix(myMatrix, "Centroids");
        System.out.println();
        
        if (eMsg.equals("N/A")){
            System.out.println(" Yours: ");
            printMatrix(drReturn, "Centroids");
            System.out.println();
        }
        else
            System.out.println(" Yours: " + eMsg + "\n");
        
        // Test 6
        numTotalTests++;
        drReturn = null;
        testResult = "[Failed]";
        eMsg = "N/A";
        try{
            k = 2;
            double[][] testData = {
                {5.8, 2, 3, 0.2},
                {5.2, 4.1, 1.5, 0.1},
                {5.9, 4.2, 1.2, 1.5},
                {5.4, 3, 4.5, 1.5}
                }; 
            data = testData;

            int[] myArray = {0, 0, 1, 0};
            clusters = myArray;
            drReturn = KM3.updateCentroids(k, clusters, data);
            
            double[][] expectedCentroids = {
                {5.47, 3.03, 3.00, 0.60},
                {5.90, 4.20, 1.20, 1.50}
                };
            myMatrix = expectedCentroids;
                        
            if (compareCentroids(expectedCentroids, drReturn)){
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e){
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }

        System.out.println("Test " + numTotalTests + ": updateCentroids - " + testResult);
        printMatrix(data, "Test records");
        System.out.println();        
        System.out.println("   Clusters: " + Arrays.toString(clusters));
        
        System.out.println(" --------------\n Expected:");
        printMatrix(myMatrix, "Centroids");
        System.out.println();
        
        if (eMsg.equals("N/A")){
            System.out.println(" Yours: ");
            printMatrix(drReturn, "Centroids");
            System.out.println();
        }
        else
            System.out.println(" Yours: " + eMsg + "\n");
        
        // Test 7
        numTotalTests++;
        double dReturn = 0.0;
        testResult = "[Failed]";
        eMsg = "N/A";
        try{
            double[][] testData = {
                {5.4, 3.4, 1.5, 0.4},
                {5.2, 4.1, 1.5, 0.1},
                {5.5, 4.2, 1.4, 0.2},
                {4.9, 3.1, 1.5, 0.1}
                }; 
            data = testData;
            
            double[][] testCentroids = {
                {5.81, 3.95, 2.05, 0.53}
                };
            centroids = testCentroids;

            int[] myArray = {0, 0, 0, 0};
            clusters = myArray;
            dReturn = KM3.calculateSSE(clusters, centroids, data);
            dReturn = Math.round(dReturn * 1000D) / 1000D;
            
            SSE = 4.4;
                        
            if (SSE == dReturn){
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e){
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }

        System.out.println("Test " + numTotalTests + ": calculateSSE - " + testResult);
        printMatrix(centroids, "Centroids");
        System.out.println();
        
        printMatrix(data, "Test records");
        System.out.println();        
        System.out.println("   Clusters: " + Arrays.toString(clusters));
        
        System.out.println(" --------------\n Expected: " + SSE);
        
        if (eMsg.equals("N/A")){
            System.out.println(" Yours: " + dReturn);
            System.out.println();
        }
        else
            System.out.println(" Yours: " + eMsg + "\n");
        
        // Test 8
        numTotalTests++;
        dReturn = 0.0;
        testResult = "[Failed]";
        eMsg = "N/A";
        try{
            double[][] testData = {
                {5.8, 2, 3, 0.2},
                {5.2, 4.1, 1.5, 0.1},
                {5.9, 4.2, 1.2, 1.5},
                {5.4, 3, 4.5, 1.5}
                }; 
            data = testData;
            
            double[][] testCentroids = {
                {5.47, 3.03, 3.00, 0.60},
                {5.90, 4.20, 1.20, 1.50}
                };
            centroids = testCentroids;

            int[] myArray = {0, 0, 1, 0};
            clusters = myArray;
            dReturn = KM3.calculateSSE(clusters, centroids, data);
            dReturn = Math.round(dReturn * 1000D) / 1000D;
            
            SSE = 8.113;
                        
            if (SSE == dReturn){
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e){
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }

        System.out.println("Test " + numTotalTests + ": calculateSSE - " + testResult);
        printMatrix(centroids, "Centroids");
        System.out.println();
        
        printMatrix(data, "Test records");
        System.out.println();
        
        System.out.println("   Clusters: " + Arrays.toString(clusters));        
        System.out.println(" --------------\n Expected: " + SSE);
        
        if (eMsg.equals("N/A")){
            System.out.println(" Yours: " + dReturn);
            System.out.println();
        }
        else
            System.out.println(" Yours: " + eMsg + "\n");

        // Test 9
        numTotalTests++;
        dReturn = 0.0;
        testResult = "[Failed]";
        eMsg = "N/A";
        try{
            k = 1;
            int[] centroidIndices = {95};
            initCentroidIndices = centroidIndices;
            
            centroids = initializeCentroids(centroidIndices, iris);
            dReturn = KM3.kMeans(k, centroids, iris);
            dReturn = Math.round(dReturn * 1000D) / 1000D;
            
            SSE = 680.824;
            
            if (SSE == dReturn){
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e){
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }

        System.out.println("Test " + numTotalTests + ": kMeans(Initial centroid indicies = " + Arrays.toString(initCentroidIndices) + ") - " + testResult);       
        System.out.println(" --------------\n Expected: " + SSE);
        
        if (eMsg.equals("N/A")){
            System.out.println(" Yours: " + dReturn);
            System.out.println();
        }
        else
            System.out.println(" Yours: " + eMsg + "\n");
        
        // Test 10
        numTotalTests++;
        dReturn = 0.0;
        testResult = "[Failed]";
        eMsg = "N/A";
        try{
            k = 2;
            int[] centroidIndices = {15, 80};
            initCentroidIndices = centroidIndices;
            
            centroids = initializeCentroids(centroidIndices, iris);
            dReturn = KM3.kMeans(k, centroids, iris);
            dReturn = Math.round(dReturn * 1000D) / 1000D;
            
            SSE = 152.369;
            
            if (SSE == dReturn){
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e){
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }

        System.out.println("Test " + numTotalTests + ": kMeans(Initial centroid indicies = " + Arrays.toString(initCentroidIndices) + ") - " + testResult);       
        System.out.println(" --------------\n Expected: " + SSE);
        
        if (eMsg.equals("N/A")){
            System.out.println(" Yours: " + dReturn);
            System.out.println();
        }
        else
            System.out.println(" Yours: " + eMsg + "\n");
        
        // Test 11
        numTotalTests++;
        dReturn = 0.0;
        testResult = "[Failed]";
        eMsg = "N/A";
        try{
            k = 3;
            int[] centroidIndices = {20, 90, 140};
            initCentroidIndices = centroidIndices;
            
            centroids = initializeCentroids(centroidIndices, iris);
            dReturn = KM3.kMeans(k, centroids, iris);
            dReturn = Math.round(dReturn * 1000D) / 1000D;
            
            SSE = 78.945;
            
            if (SSE == dReturn){
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e){
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }

        System.out.println("Test " + numTotalTests + ": kMeans(Initial centroid indicies = " + Arrays.toString(initCentroidIndices) + ") - " + testResult);       
        System.out.println(" --------------\n Expected: " + SSE);
        
        if (eMsg.equals("N/A")){
            System.out.println(" Yours: " + dReturn);
            System.out.println();
        }
        else
            System.out.println(" Yours: " + eMsg + "\n");

        System.out.println("Total test cases: " + numTotalTests + "\nCorrect: " + numPassedTests + "\nWrong: " + (numTotalTests - numPassedTests));
    }

    public static double[][] initializeCentroids(int[] centroidIndices, double[][] dataset){
        int numCols = dataset[0].length;
        int k = centroidIndices.length;        
        double[][] centroids = new double[k][numCols];
        
        for (int i = 0; i < k; i++)
            centroids[i] = dataset[centroidIndices[i]];
        
        return centroids;       
    }

    public static boolean compareCentroids(double[][] expected, double[][] test){
        if (expected.length != test.length || expected[0].length != test[0].length)
            return false;
        
        for (int i = 0; i < expected.length; i++)
            for (int j = 0; j < expected[i].length; j++)
                if (expected[i][j] != Math.round(test[i][j] * 100D) / 100D)
                    return false;

        return true;
    }
    
    public static boolean compareClusters(int[] expected, int[] test) {
        if (expected.length != test.length)
            return false;
            
        for (int i = 0; i < expected.length; i++)
            if (expected[i] != test[i])
                    return false;
        
        return true;
    }
    
    public static void printMatrix(double[][] matrix, String name){
        System.out.println("   " + name + ":");
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++)
                System.out.format("%7.2f\t", matrix[i][j]);

            System.out.println();
        }
    }
    
    public static double[][] loadMatrix(String fileName, int numRows, int numCols) { 
        double[][] glassMatrix = new double[numRows][numCols];
        int iRow = 0;
                
        try{
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            
            while((line = bufferedReader.readLine()) != null){
                int iCol = 0;
                String[] values = line.split(",");
                for (String str : values){
                    glassMatrix[iRow][iCol] = Double.parseDouble(str);
                    iCol++;
                }
                
                iRow++;
            }

            bufferedReader.close();         
        }
        catch(Exception e) {
            System.out.println("Error: " + e.getMessage());                
        }
        
        return glassMatrix;
    }
}
