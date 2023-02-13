package resources.testdata;

import org.testng.annotations.DataProvider;

import java.util.Random;

public class TestData {
    @DataProvider(name = "credentials")
    public Object[][] getDataInvalid() {
        Object[][] data = new Object[][]{
                {"sky1@gmail.com", "12345678"}

        };
        return data;
    }

    @DataProvider(name = "vaildcredentials")
    public Object[][] getDatavalid(){
        Object[][] data1 = new Object[][]{
                {"sky1@gmail.com", "12345678"}

        };
        return data1;
    }

    @DataProvider(name="BuildComputer")
    public Object[][] getDatabuild(){
        Object[][] data2 = new Object[][]{
                {"2.2 GHz Intel Pentium Dual-Core E2200", "2 GB", "320 GB", "Vista Home [+$50.00]", "Microsoft Office [+$50.00]"}
        };
        return data2;
    }


    Random randomGenrator = new Random(System.currentTimeMillis());
    int num = randomGenrator.nextInt(3);
    @DataProvider(name="registerdata")
    public Object[][] getData(){
        Object[][] data3 = new Object[][]{


                {"Hetvi","patel","10","6","1997","sky"+num+"@gmail.com","12345678","12345678","Your registration completed"},
                {"sky","patel","1","6","1996","Hetvi"+num+"@gmail.com","012345","012345","Your registration completed"}
        };
        return data3;
    }
}