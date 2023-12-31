/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto2edd;
import java.io.File;  
import java.io.FileInputStream;  
import java.io.IOException;
import java.time.LocalDate;
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
static BST2 arbolhistorial = new BST2();
static RoomsList roomslist = new RoomsList();
static ClientesHospedadosList clienteshospedadoslist = new ClientesHospedadosList();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Menu1 menu1 = new Menu1();
        menu1.setVisible(true);
        menu1.setLocationRelativeTo(null);
        cargar_habitaciones();
        cargar_datos();
        cargar_reserva();
        cargarhistorial();
    }
    
    public static void cargar_datos(){
        String texto = leer_excel(2);
        String[] clientes = texto.split("\n");
        for(int i =0;i<clientes.length;i++){
        String[] datoscliente = clientes[i].split("   ");
            if(isNumeric(datoscliente[0])){
            int roomNumber = Integer.parseInt(datoscliente[0]);
            String name = datoscliente[1];
            String apellido = datoscliente[2];
            String nombre = name+apellido;
            String correo = datoscliente[3];
            String genero = datoscliente[4];
            String celular = datoscliente[5];
            String llegada = convertToFormattedDate(datoscliente[6]);
            clientehospedado cliente = new clientehospedado(nombre,correo,genero,celular,llegada);
            ClienteHospedado2 cliente2 = new ClienteHospedado2(nombre,correo,genero,celular,llegada);
            hashtable.addGuest(cliente, roomNumber);
            clienteshospedadoslist.insert(cliente2);
            
            Room aux = roomslist.pFirst;
            while(aux!=null){
                if(aux.numero == roomNumber){
                    aux.ocupada = true;
                    break;
                }else{
                    aux = aux.getPnext();
                }
            }

            }
        }
    }
    
    public static void cargar_habitaciones(){
        String texto = leer_excel(1);
        String[] habitaciones = texto.split("\n");
        for(int i=1;i<habitaciones.length;i++){
            String[] datos = habitaciones[i].split("   ");
            int numero = Integer.parseInt(datos[0]);
            String tipo = datos[1];
            int piso = Integer.parseInt(datos[2]);
            Room room = new Room(numero,tipo,piso);
            roomslist.insert(room);
        }
    }
    
    public static void cargar_reserva(){
        String texto = leer_excel(0);
        String[] clientes = texto.split("\n");
        for(int i =1;i<clientes.length;i++){
        String[] datoscliente = clientes[i].split("   ");
        int cedula = Integer.parseInt(datoscliente[0]);
        String nombre = datoscliente[1];
        String apellido = datoscliente[2];
        String name = nombre+" "+apellido;
        String email = datoscliente[3];
        String genero = datoscliente[4];
        String roomType = datoscliente[5];
        String phone = datoscliente[6];
        String llegada = convertToFormattedDate(datoscliente[7]);
        String info = name+"/"+email+"/"+genero+"/"+roomType+"/"+phone+"/"+llegada;
        TreeNode n = new TreeNode(cedula,info);
        if(arbolcedulas.getRoot() == null){
            arbolcedulas.setRoot(n);
        }else{
            TreeNode root = arbolcedulas.getRoot();
            arbolcedulas.insert(root,n);
          }
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
    
public static void cargarhistorial(){
        String texto = leer_excel(3);
        String[] clientes = texto.split("\n");
        for(int i =1;i<clientes.length;i++){
        String[] datoscliente = clientes[i].split("   ");
        int cedula = Integer.parseInt(datoscliente[0]);
        String nombre = datoscliente[1];
        String apellido = datoscliente[2];
        String name = nombre+" "+apellido;
        String email = datoscliente[3];
        String genero = datoscliente[4];
        String llegada = convertToFormattedDate(datoscliente[5]);
        String historial ="Cedula: "+cedula+" | Nombre: "+name +" | Correo: "+email+" | Genero: "+genero+" | Llegada: "+llegada;
        String hab = datoscliente[6].replace(" ","");
        int numhab = Integer.parseInt(hab);
        Habitacion n = new Habitacion(numhab,historial);
         if(arbolhistorial.getRoot()==null){
             arbolhistorial.setRoot(n);
         }
         Habitacion aux = arbolhistorial.getRoot();
         if(arbolhistorial.isInTheTree( aux,numhab)){
           Habitacion x = arbolhistorial.search(aux,numhab);  
           x.setHistorial(n.getHistorial()+"\n"+x.getHistorial());
         }else{
            Habitacion root = arbolhistorial.getRoot();
            arbolhistorial.insert(root,n);
          }
        }
    }

    public static String convertToFormattedDate(String daysPassed) {
        int intdaysPassed = Integer.parseInt(daysPassed);
        LocalDate baseDate = LocalDate.of(1900, 1, 1);
        LocalDate targetDate = baseDate.plusDays(intdaysPassed);
        int day = targetDate.getDayOfMonth();
        int month = targetDate.getMonthValue();
        int year = targetDate.getYear();

        return String.format("%02d/%02d/%04d", day, month, year);
    }

    public static String leer_excel(int pagina){
        String texto = "";
try {
        String filePath = "src/proyecto2edd/resources/Booking_hotel.xlsx"; // Relative path to the Excel file

        File file = new File(filePath); // Creating a new file instance
        FileInputStream fis = new FileInputStream(file); // Obtaining bytes from the file

        // Creating Workbook instance that refers to .xlsx file
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(pagina); // Creating a Sheet object to retrieve the object
        Iterator<Row> itr = sheet.iterator(); // Iterating over excel file

        while (itr.hasNext()) {
            Row row = itr.next();
            Iterator<Cell> cellIterator = row.cellIterator(); // Iterating over each column

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING: // Field that represents string cell type
                        texto+= cell.getStringCellValue() + "   ";
                        break;
                    case Cell.CELL_TYPE_NUMERIC: // Field that represents number cell type
                        texto += (Integer.toString((int) cell.getNumericCellValue())+ "   ");
                        break;
                    default:
                }
            }
            texto += "\n";
        }
    
wb.close();
        fis.close();
} catch (Exception e) {
        e.printStackTrace();
    }
return texto;
    }
}
