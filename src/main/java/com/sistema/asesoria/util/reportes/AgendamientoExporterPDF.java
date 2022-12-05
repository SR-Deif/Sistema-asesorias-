package com.sistema.asesoria.util.reportes;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;

import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.sistema.asesoria.agendamiento.Agendamiento;

public class AgendamientoExporterPDF {

    private List<Agendamiento> listaAgendamientos;

    public AgendamientoExporterPDF(List<Agendamiento> listaAgendamientos) {
        this.listaAgendamientos = listaAgendamientos;
    }

    private void cabeceraTabla(PdfPTable tabla) {
        PdfPCell celda = new PdfPCell();

        celda.setBackgroundColor(Color.green);
        celda.setPadding(5);

        Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
        fuente.setColor(Color.white);

        celda.setPhrase(new Phrase("id", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("fechaAgendamiento", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("fechaRevisionAgendamiento", fuente));
        tabla.addCell(celda);

        //celda.setPhrase(new Phrase("Costo", fuente));
        //tabla.addCell(celda);
    }

    private void datosTabla(PdfPTable tabla) {

        for (Agendamiento agendamiento : listaAgendamientos) {

            // Agendamiento pr;
            // String asesoria = pr.getAsesoria().getCostoAsesoria();
            tabla.addCell(String.valueOf(agendamiento.getIdAgendamiento()));
            tabla.addCell(agendamiento.getFechaAgendamiento());
            tabla.addCell(agendamiento.getFechaRevisionAgendamiento());
            // tabla.addCell(asesoria);

        }
    }

    public void exportar(HttpServletResponse response) throws DocumentException, IOException {
        Document documento = new Document(PageSize.A4);
        PdfWriter.getInstance(documento, response.getOutputStream());

        documento.open();

        Font fuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fuente.setColor(Color.green);

        Paragraph titulo = new Paragraph("Listado de Agendamientos", fuente);
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(titulo);

        PdfPTable tabla = new PdfPTable(3);
        tabla.setWidthPercentage(100);
        tabla.setSpacingBefore(15);
        tabla.setWidths(new float[] { 1f, 1f, 1f });
        tabla.setWidthPercentage(110);

        cabeceraTabla(tabla);
        datosTabla(tabla);

        documento.add(tabla);
        documento.close();
    }
}
