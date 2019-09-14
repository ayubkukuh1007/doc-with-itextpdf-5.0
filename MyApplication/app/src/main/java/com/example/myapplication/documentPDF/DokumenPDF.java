package com.example.myapplication.documentPDF;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Environment;
import android.util.Log;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author ayubkukuh <ayubkukuhprasetyo434@gmail.com>
 * @since 1.0
 */
public class DokumenPDF {

    private Locale localeID;
    private NumberFormat formatRupiah;

    public DokumenPDF() {
        localeID = new Locale("in","ID");
        formatRupiah = NumberFormat.getCurrencyInstance(localeID);
    }

    public void createdokumenPDF (Modelstatusdetailtiappeserta.DatapaketEntity datapaket,
                                  Modelstatusdetailtiappeserta.DatapesertastatusOpenEntity open,
                                  Modelstatusdetailtiappeserta.StatusDokumenEntity dokumen,
                                  Modelstatusdetailtiappeserta.StatusPembayaranEntity pembayaran,
                                  String buttonStatusdatapeserta,
                                  String buttonStatusDokument,
                                  String buttonStatusPembayaran) {

        try {

            //path untuk menyimpan file dokument PDF
            Date now = new Date(); //tanggal sekarang
            android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss",now);
            String filename = "DokumentPDF" + now + ".pdf";
            File defaultFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/DIRDOC");
            if (!defaultFile.exists()) defaultFile.mkdirs();
            File file = new File(defaultFile,filename);
            if (file.exists()) {
                file.delete();
                file = new File(defaultFile,filename);
            }
            //buat objeck dokument
            Document document = new Document();
            PdfWriter.getInstance(document,new FileOutputStream(file));
            document.open();
            document.setPageSize(PageSize.A4);
            document.addCreationDate();

            document.addAuthor("Ayub kukuh");
            document.addCreator("Ayub k.p");

            //warna color Font
            BaseColor mColorAccent = new BaseColor(0,153,204,255);

            //ukururan Font
            float mHeadingFontSize = 20.0f;
            float mValueFontSize = 26.0f;

            //objek BaseFont besechekbox, untuk membuat kotak checkbox yang diambil dari font type windings.ttf
            //objek BaseFont baseunchekbox, untuk membuat uncheckbox yang diambil dari font type wingdings1.ttf
            BaseFont basecheckbox = BaseFont.createFont("res/font/wingdings.ttf",BaseFont.IDENTITY_H,false);
            BaseFont baseuncheckbox = BaseFont.createFont("res/font/wingdings1.ttf",BaseFont.IDENTITY_H,false);
            BaseFont montserratregular = BaseFont.createFont("res/font/montserratregular.ttf","UTF-8",BaseFont.EMBEDDED);

            //buat objeck Font dengan Constructor 3 arg : new Font(BaseFont,SizeFont,StyleFont)
            Font checkbox = new Font(basecheckbox,30f,Font.BOLD);
            Font uncheckbox = new Font(baseuncheckbox,30f,Font.NORMAL);

            //garis pemisah (garis horisaontal)
            LineSeparator lineSeparator = new LineSeparator();
            lineSeparator.setLineColor(new BaseColor(0,0,0,68));

            Font fontheader = new Font(montserratregular,36.0f,Font.NORMAL,BaseColor.BLACK);
            Font fontnormal = new Font(montserratregular,mValueFontSize,Font.NORMAL,BaseColor.BLACK);
            Font fontnormalcolorblue = new Font(montserratregular,mValueFontSize,Font.NORMAL,mColorAccent);

            //Chunk mempresentasikan potongan dari sebuah text, Chunk dapat berisi singel karater atau bebrapa kalimat

            //Nama paket
            Chunk namapaketchunk = new Chunk(datapaket.getNamapaket(),fontheader);
            Paragraph namapaketparagraf = new Paragraph(namapaketchunk);
            namapaketparagraf.setAlignment(Element.ALIGN_LEFT);
            document.add(namapaketparagraf);

            //no pesanan
            Chunk nomorpesanan = new Chunk("No.pesanan " + datapaket.getNopesanan(),fontnormalcolorblue);
            Paragraph nopesananparagraf = new Paragraph(nomorpesanan);
            nopesananparagraf.setAlignment(Element.ALIGN_LEFT);
            document.add(nopesananparagraf);

            //seprator
            document.add(new Paragraph(""));
            document.add(new Chunk(lineSeparator));
            document.add(new Paragraph(""));

            //data peserta
            Chunk datapesertachunk = new Chunk(new VerticalPositionMark());
            Paragraph datapesertaparagraf = new Paragraph("Data peserta",fontnormal);
            datapesertaparagraf.add(new Chunk(datapesertachunk));
            datapesertaparagraf.add(buttonStatusdatapeserta);
            document.add(datapesertaparagraf);

            //seprator
            document.add(new Paragraph(""));
            document.add(new Chunk(lineSeparator));
            document.add(new Paragraph(""));

            //namapeserta
            Chunk namapesertachunk = new Chunk(new VerticalPositionMark());
            Paragraph namapesertaparagraf = new Paragraph("Nama peserta",fontnormal);
            namapesertaparagraf.add(new Chunk(namapesertachunk));
            namapesertaparagraf.add(open.getNamapeserta());
            document.add(namapesertaparagraf);

            //nohp
            Chunk pnohchunk = new Chunk(new VerticalPositionMark());
            Paragraph nohpaparagraf = new Paragraph("No.Hp",fontnormal);
            nohpaparagraf.add(new Chunk(pnohchunk));
            nohpaparagraf.add(open.getNohp());
            document.add(nohpaparagraf);

            //noktp
            Chunk noktpchunk = new Chunk(new VerticalPositionMark());
            Paragraph noktpparagraf = new Paragraph("No.Ktp",fontnormal);
            noktpparagraf.add(new Chunk(noktpchunk));
            noktpparagraf.add(open.getNoktp());
            document.add(noktpparagraf);

            //nopasspor
            Chunk nopasporchunk = new Chunk(new VerticalPositionMark());
            Paragraph nopasporparagraf = new Paragraph("No.Pasport",fontnormal);
            nopasporparagraf.add(new Chunk(nopasporchunk));
            nopasporparagraf.add(open.getNopaspor());
            document.add(nopasporparagraf);

            //nopasspor
            document.add(new Paragraph(""));
            document.add(new Chunk(lineSeparator));
            document.add(new Paragraph(""));

            //status dokumen
            Chunk dokumenchunk = new Chunk(new VerticalPositionMark());
            Paragraph dokumenparagraf = new Paragraph("Status Dokumen",fontnormal);
            dokumenparagraf.add(new Chunk(dokumenchunk));
            dokumenparagraf.add(buttonStatusDokument);
            document.add(dokumenparagraf);

            document.add(new Paragraph(""));
            document.add(new Chunk(lineSeparator));
            document.add(new Paragraph(""));

            //R = untuk untuk membuat tipe checkbox
            //o = untuk membuat tipe uncheckbox
            //buat objeck table
            PdfPTable table = new PdfPTable(4); // 4 columns.

            table.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cell1 = new PdfPCell(new Paragraph(dokumen.getKtp() ? "R" : "o",dokumen.getKtp() ? checkbox : uncheckbox));
            PdfPCell cell2 = new PdfPCell(new Paragraph("KTP",fontnormal));
            PdfPCell cell3 = new PdfPCell(new Paragraph(dokumen.getFoto() ? "R" : "o",dokumen.getFoto() ? checkbox : uncheckbox));
            PdfPCell cell4 = new PdfPCell(new Paragraph("FOTO",fontnormal));
            PdfPCell cell5 = new PdfPCell(new Paragraph(dokumen.getPaspor() ? "R" : "o",dokumen.getPaspor() ? checkbox : uncheckbox));
            PdfPCell cell6 = new PdfPCell(new Paragraph("PASPORT",fontnormal));
            PdfPCell cell7 = new PdfPCell(new Paragraph(dokumen.getKartukeluarga() ? "R" : "o",dokumen.getKartukeluarga() ? checkbox : uncheckbox));
            PdfPCell cell8 = new PdfPCell(new Paragraph("KK",fontnormal));
            PdfPCell cell9 = new PdfPCell(new Paragraph(dokumen.getBukunikah() ? "R" : "o",dokumen.getBukunikah() ? checkbox : uncheckbox));
            PdfPCell cell10 = new PdfPCell(new Paragraph("BUKU NIKAH",fontnormal));
            PdfPCell cell11 = new PdfPCell(new Paragraph(dokumen.getKartukuning() ? "R" : "o",dokumen.getKartukuning() ? checkbox : uncheckbox));
            PdfPCell cell12 = new PdfPCell(new Paragraph("KARTU KUNING",fontnormal));
            PdfPCell cell13 = new PdfPCell(new Paragraph(dokumen.getKitas() ? "R" : "o",dokumen.getKitas() ? checkbox : uncheckbox));
            PdfPCell cell14 = new PdfPCell(new Paragraph("KITAS",fontnormal));
            PdfPCell cell15 = new PdfPCell(new Paragraph("",fontnormal));
            PdfPCell cell16 = new PdfPCell(new Paragraph("",fontnormal));

            //setiap cell set tanpa border
            cell1.setBorder(Rectangle.NO_BORDER);
            cell2.setBorder(Rectangle.NO_BORDER);
            cell3.setBorder(Rectangle.NO_BORDER);
            cell4.setBorder(Rectangle.NO_BORDER);
            cell5.setBorder(Rectangle.NO_BORDER);
            cell6.setBorder(Rectangle.NO_BORDER);
            cell7.setBorder(Rectangle.NO_BORDER);
            cell8.setBorder(Rectangle.NO_BORDER);
            cell9.setBorder(Rectangle.NO_BORDER);
            cell10.setBorder(Rectangle.NO_BORDER);
            cell11.setBorder(Rectangle.NO_BORDER);
            cell12.setBorder(Rectangle.NO_BORDER);
            cell13.setBorder(Rectangle.NO_BORDER);
            cell14.setBorder(Rectangle.NO_BORDER);
            cell15.setBorder(Rectangle.NO_BORDER);
            cell16.setBorder(Rectangle.NO_BORDER);
            cell3.setBorder(Rectangle.NO_BORDER);

            //setting align setiap cell
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell6.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell8.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell10.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell12.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell13.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell14.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell15.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell16.setHorizontalAlignment(Element.ALIGN_LEFT);

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            table.addCell(cell5);
            table.addCell(cell6);
            table.addCell(cell7);
            table.addCell(cell8);
            table.addCell(cell9);
            table.addCell(cell10);
            table.addCell(cell11);
            table.addCell(cell12);
            table.addCell(cell13);
            table.addCell(cell14);
            table.addCell(cell15);
            table.addCell(cell16);

            table.setWidthPercentage(100);
            float[] columnWidths = new float[]{10f,50f,10f,50f};
            table.setWidths(columnWidths);
            document.add(table);

            //seprator
            document.add(new Paragraph(""));
            document.add(new Chunk(lineSeparator));
            document.add(new Paragraph(""));

            //status pembayaran
            Chunk pembayaranchunk = new Chunk(new VerticalPositionMark());
            Paragraph pembayaranparagraf = new Paragraph("Status Pembayaran",fontnormal);
            pembayaranparagraf.add(new Chunk(pembayaranchunk));
            pembayaranparagraf.add(buttonStatusPembayaran);
            document.add(pembayaranparagraf);

            //garis horizontal
            document.add(new Paragraph(""));
            document.add(new Chunk(lineSeparator));
            document.add(new Paragraph(""));

            //tiepkamar
            Chunk tipekamarchunk = new Chunk(new VerticalPositionMark());
            Paragraph tipekamarparagraf = new Paragraph("Kamar " + pembayaran.getKamar(),fontnormal);

            //total
            tipekamarparagraf.add(new Chunk(tipekamarchunk));
            tipekamarparagraf.add("Total: " + formatRupiah.format(pembayaran.getTotal()));
            document.add(tipekamarparagraf);

            //sisa
            Chunk sisachunk = new Chunk(new VerticalPositionMark());
            Paragraph sisaparagraf = new Paragraph("",fontnormal);
            sisaparagraf.add(new Chunk(sisachunk));
            sisaparagraf.add("Sisa : " + formatRupiah.format(pembayaran.getSisa()));
            document.add(sisaparagraf);

            //pay-tanggal
            Chunk paydatebayarchunk = new Chunk(new VerticalPositionMark());
            Paragraph paydateparagraf = new Paragraph(pembayaran.getNopayment(),fontnormal);
            paydateparagraf.add(new Chunk(paydatebayarchunk));
            paydateparagraf.add(pembayaran.getTanggal());
            document.add(paydateparagraf);

            //totalbayar
            Chunk totalbayarchunk = new Chunk(new VerticalPositionMark());
            Paragraph totalbayarparagraf = new Paragraph(formatRupiah.format(pembayaran.getTotal() - pembayaran.getSisa()),fontnormal);
            totalbayarparagraf.add(new Chunk(totalbayarchunk));
            totalbayarparagraf.add("");
            document.add(totalbayarparagraf);

            //jenis pembayaran
            Chunk jenispembayaranchunk = new Chunk(new VerticalPositionMark());
            Paragraph jenispembayarannparagraf = new Paragraph(pembayaran.getJenispembayaran(),fontnormal);
            jenispembayarannparagraf.add(new Chunk(jenispembayaranchunk));
            jenispembayarannparagraf.add("");
            document.add(jenispembayarannparagraf);

            //penerima
            Chunk penerimachunk = new Chunk(new VerticalPositionMark());
            Paragraph penerimaparagraf = new Paragraph(pembayaran.getPenerima(),fontnormal);
            penerimaparagraf.add(new Chunk(penerimachunk));
            penerimaparagraf.add("");
            document.add(penerimaparagraf);

            //close dokument
            document.close();

        } catch (IOException | DocumentException ie) {
            Log.e("createPdf",ie.getLocalizedMessage());
        } catch (ActivityNotFoundException ae) {
            Log.e("createPdf",ae.getLocalizedMessage());
        }
    }
}
