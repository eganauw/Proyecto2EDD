/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto2edd;
import java.io.File;  
import java.io.FileInputStream;  
import java.io.IOException;
import java.util.Iterator;  
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 
/**
 *
 * @author rodri
 */
public class Proyecto2EDD {
static HashTable hashtable = new HashTable();
static BST arbolcedulas = new BST();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Menu menu = new Menu();
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
        cargar_datos();
        cargar_reserva();
    }
    
    public static void cargar_datos(){
        String textopag2 = "";
        String clientes[] ={"a"};
try {
        String filePath = "src/proyecto2edd/resources/Booking_hotel.xlsx"; // Relative path to the Excel file

        File file = new File(filePath); // Creating a new file instance
        FileInputStream fis = new FileInputStream(file); // Obtaining bytes from the file

        // Creating Workbook instance that refers to .xlsx file
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(2); // Creating a Sheet object to retrieve the object
        Iterator<Row> itr = sheet.iterator(); // Iterating over excel file

        while (itr.hasNext()) {
            Row row = itr.next();
            Iterator<Cell> cellIterator = row.cellIterator(); // Iterating over each column

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING: // Field that represents string cell type
                        textopag2 += cell.getStringCellValue() + "   ";
                        break;
                    case Cell.CELL_TYPE_NUMERIC: // Field that represents number cell type
                        textopag2 += (Integer.toString((int) cell.getNumericCellValue())+ "   ");
                        break;
                    default:
                }
            }
            textopag2 += "\n";
        }
        clientes = textopag2.split("\n");
        for(int i =1;i<clientes.length;i++){
        String[] datoscliente = clientes[i].split("   ");
            if(!isNumeric(datoscliente[0])){
            i++; 
            }else{
            int roomNumber = Integer.parseInt(datoscliente[0]);
            String nombre = datoscliente[1].replace(" ", "");
            String apellido = datoscliente[2].replace(" ","");
            String name = nombre+" "+apellido;
            hashtable.addGuest(name, roomNumber);

            }
        }
        hashtable.printHashTable();
        

        // Close the workbook and file input stream
        wb.close();
        fis.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
    
    public static void cargar_reserva(){
        String textopag0 = "";
        String clientes[] ={"a"};
try {
        String filePath = "src/proyecto2edd/resources/Booking_hotel.xlsx"; // Relative path to the Excel file

        File file = new File(filePath); // Creating a new file instance
        FileInputStream fis = new FileInputStream(file); // Obtaining bytes from the file

        // Creating Workbook instance that refers to .xlsx file
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0); // Creating a Sheet object to retrieve the object
        Iterator<Row> itr = sheet.iterator(); // Iterating over excel file

        while (itr.hasNext()) {
            Row row = itr.next();
            Iterator<Cell> cellIterator = row.cellIterator(); // Iterating over each column

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING: // Field that represents string cell type
                        textopag0 += cell.getStringCellValue() + "   ";
                        break;
                    case Cell.CELL_TYPE_NUMERIC: // Field that represents number cell type
                        textopag0 += (Integer.toString((int) cell.getNumericCellValue())+ "   ");
                        break;
                    default:
                }
            }
            textopag0 += "\n";
        }
        clientes = textopag0.split("\n");
        for(int i =1;i<clientes.length;i++){
        String[] datoscliente = clientes[i].split("   ");
        int cedula = Integer.parseInt(datoscliente[0]);
        String nombre = datoscliente[1].replace(" ", "");
        String apellido = datoscliente[2].replace(" ","");
        String name = nombre+" "+apellido;
        String email = datoscliente[3].replace(" "," ");
        String genero = datoscliente[4].replace(" "," ");
        String roomType = datoscliente[5].replace(" "," ");
        String phone = datoscliente[6].replace(" "," ");
        String llegada = datoscliente[7].replace(" "," ");
//        String salida = datoscliente[8].replace(" "," ");
        String info = name+" "+email+" "+genero+" "+roomType+" "+phone+" "+llegada;
//        System.out.println(info);
        TreeNode n = new TreeNode(cedula,info);
        if(arbolcedulas.getRoot() == null){
            arbolcedulas.setRoot(n);
        }else{
            TreeNode root = arbolcedulas.getRoot();
            arbolcedulas.insert(root,n);
          }
        }
        

        // Close the workbook and file input stream
        wb.close();
        fis.close();
} catch (Exception e) {
        e.printStackTrace();
    }
    }
    
    public static boolean isNumeric(String input){
        try {
        Double.parseDouble(input);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
    }
    
    
}
