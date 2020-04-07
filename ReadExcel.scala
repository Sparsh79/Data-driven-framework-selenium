package com.knoldus

import java.io.FileInputStream

import org.apache.poi.xssf.usermodel.XSSFWorkbook

trait ReadExcel {

  val excelPath = "/home/knoldus/Downloads/testdata.xlsx"
  val excelFile = new FileInputStream(excelPath)
  val workbook = new XSSFWorkbook(excelFile)


  def getData(page: Int, row: Int, col: Int): String = {

    val sheet = workbook.getSheetAt(page)
    val cell = sheet.getRow(row).getCell(col)
    cell.getStringCellValue
  }
  def getAllData(sheetNumber: Int, col: Int): List[String]= {


    val sheet = workbook.getSheetAt(sheetNumber)
    val range = sheet.getFirstRowNum + 1 to sheet.getLastRowNum
    print(range)
    val data = for (i <- range.toList)
      yield {
        val cell = sheet.getRow(i)
        cell.getCell(col).toString

      }
    data
  }
}
