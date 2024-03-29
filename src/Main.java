
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

import java.util.HashMap;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bala J
 */
public class Main extends javax.swing.JFrame {

    
    String inpath="/home/linux/disease/input";
    String outpath="/home/linux/disease/output";
    
    static DiabetesClassifier dclassify;
    
    public static Main guiinst;
    
    HashMap allclassi = new HashMap();
    
    
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        guiinst=this;
        
      
        
    }

    
    void writetolog(String content)
    {

           System.out.println(content);
          // System.out.println(content);
           SimpleAttributeSet set = new SimpleAttributeSet();

           StyleConstants.setItalic(set, true);
           StyleConstants.setForeground(set, Color.blue);

           Document doc = logtext.getStyledDocument();
            try {

                doc.insertString(doc.getLength(), content + "\n", set);


            } catch (BadLocationException ex) {

                ex.printStackTrace();
            }



    }
     
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        traindata = new javax.swing.JTextField();
        browetraindata = new javax.swing.JButton();
        doTraining = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        disname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        numf = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        classifydata = new javax.swing.JTextField();
        loadClassifyData = new javax.swing.JButton();
        Classify = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        resTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        dist = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        logtext = new javax.swing.JTextPane();
        jPanel4 = new javax.swing.JPanel();
        viewChart = new javax.swing.JButton();
        ppanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Disease Classification");

        jLabel1.setText("Data set");

        browetraindata.setText("LOAD DATASET");
        browetraindata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browetraindataActionPerformed(evt);
            }
        });

        doTraining.setText("TRAINING");
        doTraining.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doTrainingActionPerformed(evt);
            }
        });

        jLabel3.setText("Disease Name");

        jLabel4.setText("Number of Features");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(disname, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(doTraining, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(traindata, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(browetraindata, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(numf, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(traindata, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browetraindata, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(disname, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(doTraining, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133))
        );

        jTabbedPane1.addTab("Training", jPanel1);

        jLabel2.setText("Data to Classify");

        loadClassifyData.setText("LOAD DATA");
        loadClassifyData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadClassifyDataActionPerformed(evt);
            }
        });

        Classify.setText("CLASSIFY");
        Classify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClassifyActionPerformed(evt);
            }
        });

        resTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient ID", "Result"
            }
        ));
        jScrollPane2.setViewportView(resTable);

        jLabel5.setText("Disease");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addGap(0, 224, Short.MAX_VALUE)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(dist, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(classifydata, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86)
                                .addComponent(loadClassifyData, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Classify, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(247, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(classifydata, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loadClassifyData, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dist, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 42, Short.MAX_VALUE)
                .addComponent(Classify, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Classification", jPanel2);

        jScrollPane1.setViewportView(logtext);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Log", jPanel3);

        viewChart.setText("VIEW ACCURACY");
        viewChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewChartActionPerformed(evt);
            }
        });

        ppanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout ppanelLayout = new javax.swing.GroupLayout(ppanel);
        ppanel.setLayout(ppanelLayout);
        ppanelLayout.setHorizontalGroup(
            ppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
        );
        ppanelLayout.setVerticalGroup(
            ppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewChart, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ppanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewChart, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(ppanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Performance", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void browetraindataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browetraindataActionPerformed
        // TODO add your handling code here:
        
        JFileChooser jc = new JFileChooser("../");
        

        int ret = jc.showOpenDialog(this);

        if(ret == JFileChooser.APPROVE_OPTION)
        {
            File f  = jc.getSelectedFile();

            String fname = f.getAbsolutePath();

            traindata.setText(fname);


        }
        
        
    }//GEN-LAST:event_browetraindataActionPerformed

     private JFreeChart createChartForPerfChart(final XYDataset dataset, String tit,String xl,String yl) {

        // create the chart...
        final JFreeChart chart = ChartFactory.createXYLineChart(
            tit,      // chart title
            xl,                      // x axis label
            yl,                      // y axis label
            dataset,                  // data
            PlotOrientation.VERTICAL,
            true,                     // include legend
            true,                     // tooltips
            false                     // urls
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        chart.setBackgroundPaint(Color.white);

//        final StandardLegend legend = (StandardLegend) chart.getLegend();
  //      legend.setDisplaySeriesShapes(true);

        // get a reference to the plot for further customisation...
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
    //    plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, true);
        renderer.setSeriesShapesVisible(1, true);
        plot.setRenderer(renderer);

        //change the auto tick unit selection to integer units only...
        //final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        //rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        //OPTIONAL CUSTOMISATION COMPLETED.

        return chart;

    }
     
      private XYDataset createDatasetForPerfChart(String filename)
    {
       final XYSeriesCollection dataset = new XYSeriesCollection();


       XYSeries  P = new XYSeries("CNN Classifier");
       XYSeries  D = new XYSeries("Decision Tree Classifier");
       
 


       try
       {
           FileInputStream fstream = new FileInputStream(filename);
           DataInputStream in = new DataInputStream(fstream);
           BufferedReader br = new BufferedReader(new InputStreamReader(in));

           String strLine;
           //Read File Line By Line
           while ((strLine = br.readLine()) != null)   {
              // Print the content on the console
              System.out.println (strLine);

              String [] tem = strLine.split("#");

              if(tem[0].equals("P"))
              {
                 P.add(Double.parseDouble(tem[1]),Double.parseDouble(tem[2])) ;
              }
              if(tem[0].equals("D"))
              {
                 D.add(Double.parseDouble(tem[1]),Double.parseDouble(tem[2])) ;
              }
              
              



           }
           //Close the input stream
           in.close();



       }
       catch(Exception e)
       {
           e.printStackTrace();
       }

       dataset.addSeries(P);
       dataset.addSeries(D);
    


       return dataset;


    }
      
      
    private void loadClassifyDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadClassifyDataActionPerformed
        // TODO add your handling code here:
        
         JFileChooser jc = new JFileChooser("../");
        

        int ret = jc.showOpenDialog(this);

        if(ret == JFileChooser.APPROVE_OPTION)
        {
            File f  = jc.getSelectedFile();

            String fname = f.getAbsolutePath();

            classifydata.setText(fname);


        }
        
        
    }//GEN-LAST:event_loadClassifyDataActionPerformed

    private void viewChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewChartActionPerformed
        // TODO add your handling code here:
        
        
        
        
         XYDataset dataset = null;
         JFreeChart chart = null;


         
      
            
           dataset = createDatasetForPerfChart("Perfg1.txt");
           chart = createChartForPerfChart(dataset,"Accuracy",
                                                   "Training Size",
                                                   "Accuracy(%)");
            
            
    
         
         //final ChartPanel chartPanel = new ChartPanel(chart);
        //JFrame jf = new JFrame("hello");
        //jf.setContentPane(chartPanel);

        final File file1 = new File("g1.png");
        try
        {
           ChartUtilities.saveChartAsPNG(file1, chart, 300, 250);

           BufferedImage image = ImageIO.read(file1);

           ppanel.getGraphics().drawImage(image, 0, 0, null);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_viewChartActionPerformed

     public static void delete(File file)
    	throws Exception{

    	if(file.isDirectory()){

    		//directory is empty, then delete it
    		if(file.list().length==0){

    		   file.delete();
    		   System.out.println("Directory is deleted : "
                                                 + file.getAbsolutePath());

    		}else{

    		   //list all the directory contents
        	   String files[] = file.list();

        	   for (String temp : files) {
        	      //construct the file structure
        	      File fileDelete = new File(file, temp);

        	      //recursive delete
        	     delete(fileDelete);
        	   }

        	   //check the directory again, if empty then delete it
        	   if(file.list().length==0){
           	     file.delete();
        	     System.out.println("Directory is deleted : "
                                                  + file.getAbsolutePath());
        	   }
    		}

    	}else{
    		//if file, then delete it
    		file.delete();
    		System.out.println("File is deleted : " + file.getAbsolutePath());
    	}
    }
    
     
     void deleteOutPutDir(String outpath)
    {
        File directory = new File(outpath);

    	//make sure directory exists
    	if(!directory.exists()){

           System.out.println("Directory does not exist.");
           //System.exit(0);

        }else{

           try{

               delete(directory);

           }catch(Exception e){
               e.printStackTrace();
               //System.exit(0);
           }
        }
        
        
    }
     
    void writetologinred(String content)
    {
       SimpleAttributeSet set = new SimpleAttributeSet();

       StyleConstants.setItalic(set, true);
       StyleConstants.setForeground(set, Color.red);

       Document doc = logtext.getStyledDocument();
        try {

            doc.insertString(doc.getLength(), content + "\n", set);


        } catch (BadLocationException ex) {

            ex.printStackTrace();
        }

    }
       
    private void ClassifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClassifyActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel dfm = (DefaultTableModel)resTable.getModel();
        for (int i=dfm.getRowCount()-1;i>=0;i--)
        {
            dfm.removeRow(i);
        }
        
        String inpfile = inpath + "/test.txt";
        
        try
        {
            File fx = new File("results.txt");
            fx.delete();
        }
        catch(Exception ex)
        {
            
        }
        try
        {
            File fx = new File(inpfile);
            fx.delete();
        }
        catch(Exception ex)
        {
            
        }
        
        try
       {
           FileInputStream fstream = new FileInputStream(classifydata.getText());
           DataInputStream in = new DataInputStream(fstream);
           BufferedReader br = new BufferedReader(new InputStreamReader(in));

           String strLine;
           //Read File Line By Line
           while ((strLine = br.readLine()) != null)   {
              // Print the content on the console
              System.out.println (strLine);
              FileAppender.AppendtoFile(inpfile, strLine);
              
           }
       }
       catch(Exception exx)
       {
           exx.printStackTrace();
       }

         try
        {
             String di = (String)dist.getSelectedItem();

             AllClassiInfo af = (AllClassiInfo)allclassi.get(di);
            
             
             BigDataClassifierAnalysis.ec = af.dbx;
             BigDataClassifierAnalysis.poscount =0;
             
             
             JobConf conf = new JobConf(BigDataClassifierAnalysis.class);
             conf.setJobName("BigDisease Classification");

             conf.setOutputKeyClass(Text.class);
 	     conf.setOutputValueClass(IntWritable.class);

 	     conf.setMapperClass(BigDataClassifierAnalysis.Map.class);
	     //conf.setCombinerClass(OddEvenCounter.Reduce.class);
             conf.setReducerClass(BigDataClassifierAnalysis.Reduce.class);

	     conf.setInputFormat(TextInputFormat.class);
	     conf.setOutputFormat(TextOutputFormat.class);

             
             
             deleteOutPutDir(outpath);
             
	     FileInputFormat.setInputPaths(conf, new Path(inpath));
 	     FileOutputFormat.setOutputPath(conf, new Path(outpath));

             System.out.println("About to start app");
 	     JobClient.runJob(conf);
             
              try
              {

                 FileInputStream fstream = new FileInputStream("results.txt");

                 DataInputStream in = new DataInputStream(fstream);

                 BufferedReader br = new BufferedReader(new InputStreamReader(in));

                 String strLine;


                
                 //Read File Line By Line
                 while ((strLine = br.readLine()) != null)   {

                     if (strLine.length()<5) continue;
                     String [] pa = strLine.split(",");
                     
                     dfm.addRow(pa);
                 }
                 
                 br.close();
                 in.close();
                 fstream.close();
                 
                 
              }
              catch(Exception exx)
              {
                  
              }
             
             // String cth = location.getText() + "," +  BigDataClassifierAnalysis.poscount; 
              //FileAppender.AppendtoFile("locresult.txt", cth);
              
              
            
             JOptionPane.showMessageDialog(this, "Classified , pls check the results");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_ClassifyActionPerformed

    private void doTrainingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doTrainingActionPerformed
        // TODO add your handling code here:
        
        AllClassiInfo ac = new AllClassiInfo();
        ac.disname = disname.getText();
        ac.numf = Integer.parseInt(numf.getText());
        ac.dbx = new DiabetesClassifier(ac.numf);
        ac.dbx.train(traindata.getText());
        
        allclassi.put(ac.disname, ac);
       
        dist.addItem(ac.disname);
        
        JOptionPane.showMessageDialog(this, "Training completed");
        
    }//GEN-LAST:event_doTrainingActionPerformed

     
    public static String readFileAsString(String filePath)
   {

        try
        {
            StringBuffer fileData = new StringBuffer(1000);
            BufferedReader reader = new BufferedReader(
            new FileReader(filePath));
            char[] buf = new char[1024];
            int numRead=0;
            while((numRead=reader.read(buf)) != -1){
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
            buf = new char[1024];
            }
            reader.close();
            return fileData.toString();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Classify;
    private javax.swing.JButton browetraindata;
    private javax.swing.JTextField classifydata;
    private javax.swing.JTextField disname;
    private javax.swing.JComboBox dist;
    private javax.swing.JButton doTraining;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton loadClassifyData;
    private javax.swing.JTextPane logtext;
    private javax.swing.JTextField numf;
    private javax.swing.JPanel ppanel;
    private javax.swing.JTable resTable;
    private javax.swing.JTextField traindata;
    private javax.swing.JButton viewChart;
    // End of variables declaration//GEN-END:variables
}
