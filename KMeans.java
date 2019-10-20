

public class KMeans{
    // This method takes two int arrays (as number vectors) and returns the
    // Euclidean distance between the two vectors.
    
    public double euclidean(double[] A, double[] B){
        int n = A.length;
        double dist = 0;

        for (int i = 0; i < n; i++)
            dist += (A[i] - B[i]) * (A[i] - B[i]);

        return Math.sqrt(dist);
    }

    // This method takes as parameter an integer for the number of clusters, a
    // 2D double array for the cluster centroids, and a 2D double array for the
    // data set that contains test samples. It returns a 1D int array that contains
    // the cluster indices for all samples.
    public int[] assignSamples(int k, double[][] centroids, double[][] dataset){
    
       int [] solutionArr = new int[dataset.length];
         double dist = 0.0;
         int index;
         int i, j, m = 0, t = 0, g = 0;
         double min;
         
        //create array for each lenght
        //menaning euclidean dist between each array in dataSet with each array in centroids
        double [] len = new double [centroids.length];
        
        for(i=0;i < dataset.length; i++){//goes only for data setlength
            for(j=0; j < centroids.length; j++){//goes for centroids length
               
               dist = euclidean(dataset[i], centroids[j]);
               len[m++] = dist;
            }
            m= 0;
            //search for minimum in len array and keep the index where we found it and populate solution array
            index = -1;
            min = 100.0;
            
            for(t = 0; t < len.length; t++){
               if(len[t] < min){
                 min = len[t];
                 index = t; 
               }
            }
            solutionArr[g++] = index;
        }//end outter
         
         return solutionArr;
   }

    // This method takes as parameter an integer for the number of clusters, a 1D
    // int array that contains the cluster indices for all samples, and a 2D
    // double array for the data set that contains test samples. It returns a
    // 2D double array that contains the updated cluster centroids.
    public double[][] updateCentroids(int k, int[] clusters, double[][] dataset){

      int howManyDuplicates = 0;
      int i = 0, j = 0;
      int m = 0, n =0;
      double [][] solution = new double[k][dataset[0].length];

      double [][] columnSum = new double[k][dataset[0].length];
      
     
      for(i = 0; i < k; i++){
         for(j = 0; j < clusters.length; j++){
            if(clusters[j] == i){
               for(m = 0; m < dataset[0].length; m++){
                   columnSum[i][m] += dataset[j][m];
               }
               howManyDuplicates++;
            }//end if
         }
         for(n = 0; n < dataset[0].length; n++)
            solution[i][n] = columnSum[i][n] / howManyDuplicates;
            
        howManyDuplicates = 0;

      }//end outter
      return solution;
    }

    // This method takes as parameter an int array that contains the cluster indicies
    // for all samples, a 2D double array for the cluster centroids, and a 2D double
    // array for the data set that contains test samples. It returns the sum of squared
    // error (SSE) for the clusters.
   public  double calculateSSE(int[] clusters, double[][] centroids, double[][] dataset){
  
         double ar = 0.0;
         int i=0;
         
         for(i= 0;i < dataset.length; i++) {
            ar += euclidean(dataset[i],centroids[clusters[i]]) * euclidean(dataset[i],centroids[clusters[i]]);
         }

        return ar; 
    }

   
   
   
    // This method implements the k-means clustering algorithm. It takes an integer
    // for the number of clusters, a 2D double array for the cluster centroids, and
    // a 2D double array for the data set that contains test samples. It returns the
    // final SSE after the clustering process converges.
  
    public double kMeans(int k, double[][] centroids, double[][] dataset){
      double sseFromAboveMethod = 0.0;
      double SSE_After_k_Means = 0.0;
      
    do{ 
         //assignning the final SSE with the sse that we know so far
          SSE_After_k_Means = sseFromAboveMethod;
         
         //assigning samples from the above method
         int [] c = assignSamples(k,centroids,dataset);
      
         //calculating the sse and update it always
         sseFromAboveMethod = calculateSSE(c,centroids,dataset);
     
         //updating the centroids
         centroids = updateCentroids(k, c,dataset);      
   
    }while(Math.abs(sseFromAboveMethod - SSE_After_k_Means) != 0);//i use Math.abs becasue the difference can't be negative
    
    return SSE_After_k_Means;//I could have also returned the final asignment array to prove it's correct
    }
}
