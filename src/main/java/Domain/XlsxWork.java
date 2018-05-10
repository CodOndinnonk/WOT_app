package Domain;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class XlsxWork {



    /**
     * Возвращает цифровое значение ячейки
     * @param cell ячейка из строки
     * @return
     */
    public static Double readNumberFromCell(XSSFCell cell){
        return Double.valueOf(readValueFromCell(cell));
    }



    /**
     * Возвращает значение ячейки в виде СТРОКИ
     * @param cell ячейка из строки
     * @return null -> пустая ячейка, числа возвращаются в виде строки
     */
    public static String readValueFromCell(XSSFCell cell){
        if (cell == null){return null;}
        int cellType = cell.getCellType();
        if ((cell == null) || (cell.getCellType() == XSSFCell.CELL_TYPE_BLANK)) {
            return null;
        }
        switch (cellType) {
            case XSSFCell.CELL_TYPE_BLANK:
                return null;
            case XSSFCell.CELL_TYPE_STRING:
                return cell.getStringCellValue();
            case XSSFCell.CELL_TYPE_NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            default:
                return null;
        }
    }




    public static void readFromExcel(String file)  {
        //экселевский документ
        XSSFWorkbook myExcelBook = null;
        //список для строк в странице
        ArrayList<XSSFRow> rows = new ArrayList<XSSFRow>();
        //название страницы с настройками видимости других страниц
        String settingsSheetName = "settings";

        try {
            myExcelBook = new XSSFWorkbook(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //кол-во станиц в документе
        int sheetsAmt = myExcelBook.getNumberOfSheets();
        System.out.print("\nвсего страниц = " + myExcelBook.getNumberOfSheets());

        //карта с порядковым номером стр и ее именем
        Map<Integer, String> sheetsNames = new HashMap<Integer, String>();

        //заполняем карту страниц
        for (int i = 0; i < sheetsAmt; i++) {
            sheetsNames.put(i,myExcelBook.getSheetName(i));
            System.out.print("\nСтраница " + (i+1)+" "+myExcelBook.getSheetName(i));
        }

        //заполняем карту обрабатываемых страниц
        Map<String,Double> isSheetProcessing = new HashMap<String, Double>();
        //кол-во столбцов для использования (2, так как название листа и флаг)
        int listNamePosition = 0;
        int listProcessingFlagPosition = 1;

        //записываем в лист все строки файла
        for (int i = 0; i <= myExcelBook.getSheet(settingsSheetName).getLastRowNum(); i++) {
            XSSFRow row = myExcelBook.getSheet(settingsSheetName).getRow(i);
            isSheetProcessing.put(readValueFromCell(row.getCell(listNamePosition)),readNumberFromCell(row.getCell(listProcessingFlagPosition)));
        }

//        XSSFSheet myExcelSheet = myExcelBook.getSheetAt(0);

        //карта с именем страницы и списком строк
        Map<String,ArrayList<XSSFRow>> sheetsValues = new HashMap<String, ArrayList<XSSFRow>>();//имя страницы и значения строк




        //перелистывем все страницы файла
        for (int j=0; j<myExcelBook.getNumberOfSheets();j++) {
            //если обрабатываемая страница не является страницей настроек и на странице настроек лист обозначен как обрабатываемый (1)
            if((myExcelBook.getSheetAt(j).getSheetName().equals(settingsSheetName)) || (isSheetProcessing.get(myExcelBook.getSheetAt(j).getSheetName()) > 0)) {
                //записываем в лист все строки файла
                for (int i = 0; i < myExcelBook.getSheetAt(j).getLastRowNum(); i++) {
                    XSSFRow row = myExcelBook.getSheetAt(j).getRow(i);
                    //заполняем лист со строками на странице
                    rows.add(row);
                }
                //забиваем в карту название страницы и все ее строки
                sheetsValues.put(myExcelBook.getSheetAt(j).getSheetName(), new ArrayList<XSSFRow>(rows));
                //очищаем список строк, для исспользования для следующей страницы
                rows.clear();
            }
        }


        //поочередно берем все значения строк из страницы
        //по всем страницам
        String line = "";

        //номер обрабатываемой страницы
        int rowN;
        //перелистывем все страницы файла
        for (int j=0; j<myExcelBook.getNumberOfSheets();j++) {
            rowN = 0;
            //перебираем строки
            for (XSSFRow thisRow : sheetsValues.get(myExcelBook.getSheetAt(j).getSheetName())) {
                if (thisRow != null) {
                    //перебираем ячейки

// неправильный перебор из thisRow надо брать только ячейки с их значениями, а не все вподряд
                    for (int k = 0; k < thisRow.getLastCellNum(); k++) {
                        //если ячейка не null (было что-то написано когда-то)
                        if (thisRow.getCell(k) != null) {

                            int i1 = thisRow.getCell(k).getCellType();


                            //если ячейка не пустая, имеет содержимое
                            if (thisRow.getCell(k).getCellType() != XSSFCell.CELL_TYPE_BLANK) {
                                line += thisRow.getCell(k) + ", ";
                            } else {}
                        } else {}
                    }
                    System.out.println("\n" + myExcelBook.getSheetAt(j).getSheetName() + " Строка " + rowN + ": " + line);
                }else {}
                line = "";
                rowN++;
            }
        }





//        if(row.getCell(0).getCellType() == HSSFCell.CELL_TYPE_STRING){
//            String name = row.getCell(0).getStringCellValue();
//            System.out.println("name : " + name);
//        }


        try {
            myExcelBook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
