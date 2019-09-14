package com.example.myapplication.documentPDF;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**

 * @author ayubkukuh <ayubkukuhprasetyo434@gmail.com>
 * @since 1.0
 */
public class Modelstatusdetailtiappeserta {

    @Expose
    @SerializedName("ButtonStatusPembayaran")
    private String ButtonStatusPembayaran;
    @Expose
    @SerializedName("ButtonStatusDokument")
    private String ButtonStatusDokument;
    @Expose
    @SerializedName("ButtonStatusdatapeserta")
    private String ButtonStatusdatapeserta;
    @Expose
    @SerializedName("statusPembayaran")
    private StatusPembayaranEntity statusPembayaran;
    @Expose
    @SerializedName("statusDokumen")
    private StatusDokumenEntity statusDokumen;
    @Expose
    @SerializedName("datapesertastatusDone")
    private DatapesertastatusDoneEntity datapesertastatusDone;
    @Expose
    @SerializedName("datapesertastatusOntrip")
    private DatapesertastatusOntripEntity datapesertastatusOntrip;
    @Expose
    @SerializedName("datapesertastatusWaiting")
    private DatapesertastatusWaitingEntity datapesertastatusWaiting;
    @Expose
    @SerializedName("datapesertastatusScheduled")
    private DatapesertastatusScheduledEntity datapesertastatusScheduled;
    @Expose
    @SerializedName("datapesertastatusApprove")
    private DatapesertastatusApproveEntity datapesertastatusApprove;
    @Expose
    @SerializedName("datapesertastatusOpen")
    private DatapesertastatusOpenEntity datapesertastatusOpen;
    @Expose
    @SerializedName("datapaket")
    private DatapaketEntity datapaket;
    @Expose
    @SerializedName("dataSession")
    private DataSessionEntity dataSession;

    public String getButtonStatusPembayaran() {
        return ButtonStatusPembayaran;
    }

    public void setButtonStatusPembayaran(String ButtonStatusPembayaran) {
        this.ButtonStatusPembayaran = ButtonStatusPembayaran;
    }

    public String getButtonStatusDokument() {
        return ButtonStatusDokument;
    }

    public void setButtonStatusDokument(String ButtonStatusDokument) {
        this.ButtonStatusDokument = ButtonStatusDokument;
    }

    public String getButtonStatusdatapeserta() {
        return ButtonStatusdatapeserta;
    }

    public void setButtonStatusdatapeserta(String ButtonStatusdatapeserta) {
        this.ButtonStatusdatapeserta = ButtonStatusdatapeserta;
    }

    public StatusPembayaranEntity getStatusPembayaran() {
        return statusPembayaran;
    }

    public void setStatusPembayaran(StatusPembayaranEntity statusPembayaran) {
        this.statusPembayaran = statusPembayaran;
    }

    public StatusDokumenEntity getStatusDokumen() {
        return statusDokumen;
    }

    public void setStatusDokumen(StatusDokumenEntity statusDokumen) {
        this.statusDokumen = statusDokumen;
    }

    public DatapesertastatusDoneEntity getDatapesertastatusDone() {
        return datapesertastatusDone;
    }

    public void setDatapesertastatusDone(DatapesertastatusDoneEntity datapesertastatusDone) {
        this.datapesertastatusDone = datapesertastatusDone;
    }

    public DatapesertastatusOntripEntity getDatapesertastatusOntrip() {
        return datapesertastatusOntrip;
    }

    public void setDatapesertastatusOntrip(DatapesertastatusOntripEntity datapesertastatusOntrip) {
        this.datapesertastatusOntrip = datapesertastatusOntrip;
    }

    public DatapesertastatusWaitingEntity getDatapesertastatusWaiting() {
        return datapesertastatusWaiting;
    }

    public void setDatapesertastatusWaiting(DatapesertastatusWaitingEntity datapesertastatusWaiting) {
        this.datapesertastatusWaiting = datapesertastatusWaiting;
    }

    public DatapesertastatusScheduledEntity getDatapesertastatusScheduled() {
        return datapesertastatusScheduled;
    }

    public void setDatapesertastatusScheduled(DatapesertastatusScheduledEntity datapesertastatusScheduled) {
        this.datapesertastatusScheduled = datapesertastatusScheduled;
    }

    public DatapesertastatusApproveEntity getDatapesertastatusApprove() {
        return datapesertastatusApprove;
    }

    public void setDatapesertastatusApprove(DatapesertastatusApproveEntity datapesertastatusApprove) {
        this.datapesertastatusApprove = datapesertastatusApprove;
    }

    public DatapesertastatusOpenEntity getDatapesertastatusOpen() {
        return datapesertastatusOpen;
    }

    public void setDatapesertastatusOpen(DatapesertastatusOpenEntity datapesertastatusOpen) {
        this.datapesertastatusOpen = datapesertastatusOpen;
    }

    public DatapaketEntity getDatapaket() {
        return datapaket;
    }

    public void setDatapaket(DatapaketEntity datapaket) {
        this.datapaket = datapaket;
    }

    public DataSessionEntity getDataSession() {
        return dataSession;
    }

    public void setDataSession(DataSessionEntity dataSession) {
        this.dataSession = dataSession;
    }

    public static class StatusPembayaranEntity {
        @Expose
        @SerializedName("penerima")
        private String penerima;
        @Expose
        @SerializedName("tanggal")
        private String tanggal;
        @Expose
        @SerializedName("jenispembayaran")
        private String jenispembayaran;
        @Expose
        @SerializedName("nopayment")
        private String nopayment;
        @Expose
        @SerializedName("sisa")
        private int sisa;
        @Expose
        @SerializedName("total")
        private int total;
        @Expose
        @SerializedName("kamar")
        private String kamar;

        public String getPenerima() {
            return penerima;
        }

        public void setPenerima(String penerima) {
            this.penerima = penerima;
        }

        public String getTanggal() {
            return tanggal;
        }

        public void setTanggal(String tanggal) {
            this.tanggal = tanggal;
        }

        public String getJenispembayaran() {
            return jenispembayaran;
        }

        public void setJenispembayaran(String jenispembayaran) {
            this.jenispembayaran = jenispembayaran;
        }

        public String getNopayment() {
            return nopayment;
        }

        public void setNopayment(String nopayment) {
            this.nopayment = nopayment;
        }

        public int getSisa() {
            return sisa;
        }

        public void setSisa(int sisa) {
            this.sisa = sisa;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public String getKamar() {
            return kamar;
        }

        public void setKamar(String kamar) {
            this.kamar = kamar;
        }
    }

    public static class StatusDokumenEntity {
        @Expose
        @SerializedName("kartukuning")
        private boolean kartukuning;
        @Expose
        @SerializedName("kartukeluarga")
        private boolean kartukeluarga;
        @Expose
        @SerializedName("foto")
        private boolean foto;
        @Expose
        @SerializedName("kitas")
        private boolean kitas;
        @Expose
        @SerializedName("bukunikah")
        private boolean bukunikah;
        @Expose
        @SerializedName("paspor")
        private boolean paspor;
        @Expose
        @SerializedName("ktp")
        private boolean ktp;

        public boolean getKartukuning() {
            return kartukuning;
        }

        public void setKartukuning(boolean kartukuning) {
            this.kartukuning = kartukuning;
        }

        public boolean getKartukeluarga() {
            return kartukeluarga;
        }

        public void setKartukeluarga(boolean kartukeluarga) {
            this.kartukeluarga = kartukeluarga;
        }

        public boolean getFoto() {
            return foto;
        }

        public void setFoto(boolean foto) {
            this.foto = foto;
        }

        public boolean getKitas() {
            return kitas;
        }

        public void setKitas(boolean kitas) {
            this.kitas = kitas;
        }

        public boolean getBukunikah() {
            return bukunikah;
        }

        public void setBukunikah(boolean bukunikah) {
            this.bukunikah = bukunikah;
        }

        public boolean getPaspor() {
            return paspor;
        }

        public void setPaspor(boolean paspor) {
            this.paspor = paspor;
        }

        public boolean getKtp() {
            return ktp;
        }

        public void setKtp(boolean ktp) {
            this.ktp = ktp;
        }
    }

    public static class DatapesertastatusDoneEntity {
        @Expose
        @SerializedName("keterangan")
        private String keterangan;
        @Expose
        @SerializedName("namapeserta")
        private String namapeserta;

        public String getKeterangan() {
            return keterangan;
        }

        public void setKeterangan(String keterangan) {
            this.keterangan = keterangan;
        }

        public String getNamapeserta() {
            return namapeserta;
        }

        public void setNamapeserta(String namapeserta) {
            this.namapeserta = namapeserta;
        }
    }

    public static class DatapesertastatusOntripEntity {
        @Expose
        @SerializedName("keterangan")
        private String keterangan;
        @Expose
        @SerializedName("namapeserta")
        private String namapeserta;

        public String getKeterangan() {
            return keterangan;
        }

        public void setKeterangan(String keterangan) {
            this.keterangan = keterangan;
        }

        public String getNamapeserta() {
            return namapeserta;
        }

        public void setNamapeserta(String namapeserta) {
            this.namapeserta = namapeserta;
        }
    }

    public static class DatapesertastatusWaitingEntity {
        @Expose
        @SerializedName("keterangan")
        private String keterangan;
        @Expose
        @SerializedName("namapeserta")
        private String namapeserta;

        public String getKeterangan() {
            return keterangan;
        }

        public void setKeterangan(String keterangan) {
            this.keterangan = keterangan;
        }

        public String getNamapeserta() {
            return namapeserta;
        }

        public void setNamapeserta(String namapeserta) {
            this.namapeserta = namapeserta;
        }
    }

    public static class DatapesertastatusScheduledEntity {
        @Expose
        @SerializedName("nopaspor")
        private String nopaspor;
        @Expose
        @SerializedName("noktp")
        private String noktp;
        @Expose
        @SerializedName("nohp")
        private String nohp;
        @Expose
        @SerializedName("namapeserta")
        private String namapeserta;

        public String getNopaspor() {
            return nopaspor;
        }

        public void setNopaspor(String nopaspor) {
            this.nopaspor = nopaspor;
        }

        public String getNoktp() {
            return noktp;
        }

        public void setNoktp(String noktp) {
            this.noktp = noktp;
        }

        public String getNohp() {
            return nohp;
        }

        public void setNohp(String nohp) {
            this.nohp = nohp;
        }

        public String getNamapeserta() {
            return namapeserta;
        }

        public void setNamapeserta(String namapeserta) {
            this.namapeserta = namapeserta;
        }
    }

    public static class DatapesertastatusApproveEntity {
        @Expose
        @SerializedName("nopaspor")
        private String nopaspor;
        @Expose
        @SerializedName("noktp")
        private String noktp;
        @Expose
        @SerializedName("nohp")
        private String nohp;
        @Expose
        @SerializedName("namapeserta")
        private String namapeserta;

        public String getNopaspor() {
            return nopaspor;
        }

        public void setNopaspor(String nopaspor) {
            this.nopaspor = nopaspor;
        }

        public String getNoktp() {
            return noktp;
        }

        public void setNoktp(String noktp) {
            this.noktp = noktp;
        }

        public String getNohp() {
            return nohp;
        }

        public void setNohp(String nohp) {
            this.nohp = nohp;
        }

        public String getNamapeserta() {
            return namapeserta;
        }

        public void setNamapeserta(String namapeserta) {
            this.namapeserta = namapeserta;
        }
    }

    public static class DatapesertastatusOpenEntity {
        @Expose
        @SerializedName("nopaspor")
        private String nopaspor;
        @Expose
        @SerializedName("noktp")
        private String noktp;
        @Expose
        @SerializedName("nohp")
        private String nohp;
        @Expose
        @SerializedName("namapeserta")
        private String namapeserta;

        public String getNopaspor() {
            return nopaspor;
        }

        public void setNopaspor(String nopaspor) {
            this.nopaspor = nopaspor;
        }

        public String getNoktp() {
            return noktp;
        }

        public void setNoktp(String noktp) {
            this.noktp = noktp;
        }

        public String getNohp() {
            return nohp;
        }

        public void setNohp(String nohp) {
            this.nohp = nohp;
        }

        public String getNamapeserta() {
            return namapeserta;
        }

        public void setNamapeserta(String namapeserta) {
            this.namapeserta = namapeserta;
        }
    }

    public static class DatapaketEntity {
        @Expose
        @SerializedName("namapaket")
        private String namapaket;
        @Expose
        @SerializedName("nopesanan")
        private String nopesanan;
        @Expose
        @SerializedName("idpeserta")
        private String idpeserta;

        public String getNamapaket() {
            return namapaket;
        }

        public void setNamapaket(String namapaket) {
            this.namapaket = namapaket;
        }

        public String getNopesanan() {
            return nopesanan;
        }

        public void setNopesanan(String nopesanan) {
            this.nopesanan = nopesanan;
        }

        public String getIdpeserta() {
            return idpeserta;
        }

        public void setIdpeserta(String idpeserta) {
            this.idpeserta = idpeserta;
        }
    }

    public static class DataSessionEntity {
        @Expose
        @SerializedName("message")
        private String message;
        @Expose
        @SerializedName("level")
        private String level;
        @Expose
        @SerializedName("nama")
        private String nama;
        @Expose
        @SerializedName("id_user")
        private String id_user;
        @Expose
        @SerializedName("token")
        private String token;
        @Expose
        @SerializedName("status")
        private int status;
        @Expose
        @SerializedName("loginStatus")
        private boolean loginStatus;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public String getId_user() {
            return id_user;
        }

        public void setId_user(String id_user) {
            this.id_user = id_user;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public boolean getLoginStatus() {
            return loginStatus;
        }

        public void setLoginStatus(boolean loginStatus) {
            this.loginStatus = loginStatus;
        }
    }
}
