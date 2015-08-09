package util;



import java.io.*;
 public  class SaveTestResult {

	 
	 public void recordresult(Boolean testResult,String testCaseId,String test_desc)
	 {
		 if(testResult)
		 {
			 System.out.println(testCaseId+" pass "+test_desc);
			 writeTestResult(testCaseId+ ":: pass "+test_desc);
		 }
		 else
		 {  System.out.println(testCaseId+" fail "+test_desc);
			 writeTestResult(testCaseId+ ":: fail "+test_desc); 
		 }
	 }
	 
	protected void writeTestResult(String result){	
		 
		try{
				File f=new File("C:\\sel\\ResultFile.txt");
				FileWriter fw = new FileWriter(f,true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(result);
            	bw.newLine();
            	bw.flush();
            	bw.close();         
			}catch (IOException e) {
                e.printStackTrace();
         }
     }
	protected void writeFailureLogs(String result){	
	
		
		try{  
				File fl=new File("C:\\sel\\ResultFail.txt");
				FileWriter fw = new FileWriter(fl,true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(result);
				
            	bw.newLine();
            	bw.flush();
            	bw.close();
            	
			}catch (IOException e) {
                e.printStackTrace();
         }
     }
	protected void writePassCaseInfo(String result){	

		
		try{ 
				File fl=new File("C:\\sel\\ResultPass.txt");
				FileWriter fw = new FileWriter(fl,true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(result);
            	bw.newLine();
            	bw.flush();
            	bw.close(); 
            	
			}catch (IOException e) {
                e.printStackTrace();
         }
     }
}

