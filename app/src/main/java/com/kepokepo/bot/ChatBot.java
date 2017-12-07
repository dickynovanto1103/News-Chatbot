package com.kepokepo.bot;


public class ChatBot {
    private static int batasMaksimalBerita, indeksBerita = 0;
    private static boolean found = false;
    private static String berita = null;
    private static String[] judul = new String[20];
    private static String[] sumber = new String[20];
    private static String[] link = new String[20];
    private static String getBantuan() {
        String response = "Butuh bantuan?<br>" +
                "> ketik berita, lalu diikuti dengan topik tertentu<br>" +
                "> ketik kategori<br>" +
                "> ketik berita terpanas";
        return response;
    }
    public static String getResponse(String message) {
        message = message.toLowerCase();

        // decide bot response
        // untuk menghandle keyword yang tidak dimengerti bot
        String response = "Hmm..Coba ulangi? Aku ga paham maksudmu :(<br><br>";
        response += getBantuan();


        // interactivity
        if (message.contains("thank you") || message.contains("makasih") ||
                (message.contains("terima") && message.contains("kasih"))) {
            response = "Sama-samaa! Jangan lupa <b>KepoKepo</b> berita " +
                    "terbaru di sekitarmu lagi ya!";
            return response;
        }
        if (message.contains("pagi")){
            response = "Selamat pagi :D..selamat beraktivitas";
            return response;
        }
        if (message.contains("siang")){
            response = "Selamat siang :D..semangat beraktivitas ya!!";
            return response;
        }
        if (message.contains("sore")){
            response = "Selamat sore :D..semangat ya menjalani hari ini!!";
            return response;
        }
        if (message.contains("malam")){
            response = "Selamat malam :D..jangan lupa beristirahat";
            return response;
        }
        if (message.contains("ok")) {
            response = ":D";
            return response;
        }

        // show category
        if (message.contains("kategori") || message.contains("berita apa " +
                "aja")) {
            response = "Ini nih kategori beritanya : <br>" +
                    "> Olahraga<br>" +
                    "> Politik<br>" +
                    "> Gosip<br>" +
                    "> Kuliner<br>" +
                    "> Wisata<br>" +
                    "> Mancanegara<br>"+
                    "> Bisnis<br>"+
                    "> Seni<br>"+
                    "> Kuliner<br>"+
                    "> Hobi<br>"+
                    "> Teknologi<br>"+
                    "> Nasional<br>"+
                    "> Kesehatan<br>"+
                    "> Pekerjaan<br><br>"+
                    "Tinggal <b>ketik kategorinya</b> aja ya :D<br>";
            return response;
        }

        // help
        if (message.contains("bantuan") || message.contains("tolong") || message.contains("help")) {
            response = getBantuan();
            return response;
        }

        // identitas bot
        if (message.contains("namamu") && message.contains("siapa")) {
            response = "Halo, namaku <b>KepoKepo</b><br>";
            return response;
        }
        // merespon sapaan
        if (message.contains("halo")) {
            response = "Hai :D<br>";
            return response;
        }else if(message.contains("hai")) {
            response = "Halo :D<br>";
            return response;
        }else if(message.contains("kabar")) {
            response = "Luar biasa :D<br>";
            return response;
        }
        //merenspon emoticon
        if (message.contains(":)")) {
            response = "Wah senyummu manis :)<br>";
            return response;
        }else if(message.contains(":\\D")) {
            response = "Ceria sekali kamu :D Tuhan memberkati<br>";
            return response;
        }else if(message.contains(":(")) {
            response = "Jangan sedih atuh :( Mari kita semangat <br>";
            return response;
        }else if(message.contains(":\"")) {
            response = "Jangan nangis ya, yuk-yuk naikkan moodmu :D <br>";
            return response;
        }

        //SCOPE BERITA



        if (message.contains("lain")) {
            if(berita==null){
                response = "Anda belum memilih berita<br><br>";
                response += getBantuan();
            }else{
                //pasti sudah memiliki maksimal jumlah berita
                if(indeksBerita==batasMaksimalBerita) {
                    response = "Tidak ada berita lain lagi :( coba cari berita lain lagi<br><br>";
                    response += getBantuan();
                    return response;
                }
                response = "";
                for(int i=indeksBerita; i<(Math.min(indeksBerita+3, batasMaksimalBerita));i++) {
                    if(i==indeksBerita) {
                        response ="<h4>Berikut berita " +
                                berita +
                                " terkini:</h4>";
                    }
                    response +=
                            judul[i] +
                                    "<p style='color:#7f8c8d'><small>(sumber: " +
                                    sumber[i] +
                                    ")</small></p>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; " +
                                    " <b>Kepo? </b><a href='" +
                                    link[i] +
                                    "'>Baca disini</a><br><br>";
                }
                found = false;
                indeksBerita = Math.min(indeksBerita+3, batasMaksimalBerita);

            }
        }
        // berita terpanas
        if (message.contains("berita") && (message.contains("panas") || message.contains("terkini") || message.contains("baru"))) {
            response = "";
            berita = "panas";
            judul[0] = "SBY bertemu Jokowi, PD: Presiden Setuju Revisi UU Ormas";
            sumber[0] = "news.detik.com";
            link[0] = "https://news.detik.com/berita/3703430/sby-bertemu-jokowi-pd-presiden-setuju-revisi-uu-ormas";

            judul[1]="Hanya Dua Parpol yang Kembali Serahkan Pendaftaran ke KPUD Magelang";
            sumber[1] = "http://www.aktual.com";
            link[1] = "http://www.aktual.com/hanya-dua-parpol-yang-kembali-serahkan-pendaftaran-ke-kpud-magelang/";

            judul[2] = "Novanto Dilaporkan ke MKD DPR";
            sumber[2] = "http://www.aktual.com";
            link[2] = "http://www.aktual.com/novanto-dilaporkan-ke-mkd-dpr/";

            judul[3] = "Kembali Periksa Dokumen 9 Parpol, KPU: Semua Tidak Lengkap";
            sumber[3] = "http://www.aktual.com/";
            link[3] = "http://www.aktual.com/kembali-periksa-dokumen-9-parpol-kpu-semua-tidak-lengkap/";

            batasMaksimalBerita = 4;
            found = true;
        }

        // based on category

        //untuk section olahraga
        if (message.contains("olahraga")) {

            response = "Buat berita olahraga, ini kategori-kategorinya: <br>" +
                    "> Sepak bola<br>" +
                    "> Basket<br>" +
                    "> MotoGP<br>" +
                    "> Formula 1<br>" +
                    "> Tenis<br>" +
                    "> Tenis Meja<br><br>" +

                    "Tinggal <b>ketik kategorinya</b> aja ya :D<br>";
            return response;
        }

        if (message.contains("sepak bola") || message.contains("sepakbola")) {
            berita = "sepak bola";
            judul[0] = "Higuain Cetak Gol, Juventus Beri Kekalahan Perdana untuk Napoli";
            sumber[0] = "http://www.bola.com";
            link[0] = "http://www.bola.com/dunia/read/3182284/higuain-cetak-gol-juventus-beri-kekalahan-perdana-untuk-napoli?medium=Headline&campaign=Headline_click_1";

            judul[1] = "Kiper Andalan Timnas Jerman Waspadai Kejutan Swedia";
            sumber[1] = "http://www.bola.com";
            link[1] = "http://www.bola.com/dunia/read/3182273/kiper-andalan-timnas-jerman-waspadai-kejutan-swedia";

            judul[2] = "Persebaya Surabaya Tak Khawatir Ditinggal Pemain Kunci";
            sumber[2] = "http://www.bola.com";
            link[2] = "http://www.bola.com/indonesia/read/3182244/persebaya-surabaya-tak-khawatir-ditinggal-pemain-kunci";

            batasMaksimalBerita = 3;
            found = true;
        }

        if (message.contains("basket")) {
            berita = "basket";
            judul[0] = "Bulls Telan Kekalahan ke-18, yang ke-8 secara Beruntun";
            sumber[0] = "https://sport.detik.com/basket";
            link[0] = "https://sport.detik.com/basket/d-3751978/bulls-telan-kekalahan-ke-18-yang-ke-8-secara-beruntun";

            judul[1] = "Cavaliers Menang 10 Kali Beruntun, Terpanjang Sejak 2015/2016";
            sumber[1] = "https://sport.detik.com/basket";
            link[1] = "https://sport.detik.com/basket/d-3751362/cavaliers-menang-10-kali-beruntun-terpanjang-sejak-20152016";

            judul[2] = "Cavs Menang, LeBron Pertama Kali Diusir di Tengah Game";
            sumber[2] = "https://sport.detik.com/basket";
            link[2] = "https://sport.detik.com/basket/d-3748074/cavs-menang-lebron-pertama-kali-diusir-di-tengah-game";

            batasMaksimalBerita = 3;
            found = true;
        }

        if (message.contains("motogp")) {
            berita = "motogp";
            judul[0] = "MotoGP: Rossi Khawatirkan Kebangkitan Lorenzo";
            sumber[0] = "http://bola.liputan6.com";
            link[0] = "http://bola.liputan6.com/read/3182338/motogp-rossi-khawatirkan-kebangkitan-lorenzo";

            judul[1] = "Valentino Rossi Mengaku Blunder di MotoGP 2017";
            sumber[1] = "https://www.cnnindonesia.com";
            link[1] = "https://www.cnnindonesia.com/olahraga/20171201152004-156-259502/valentino-rossi-mengaku-blunder-di-motogp-2017/";

            judul[2] = "MotoGP: Gagal Juara Lagi, Ini Kata Rossi";
            sumber[2] = "http://www.bola.com/moto-gp";
            link[2] = "http://www.bola.com/moto-gp/read/3182446/motogp-gagal-juara-lagi-ini-kata-rossi";

            batasMaksimalBerita = 3;
            found = true;
        }

        if (message.contains("formula 1")) {
            berita = "formula 1";
            judul[0] = "Gagal Formula 1, Rio Haryanto Jajal Balap di Formula E";
            sumber[0] = "http://news.liputan6.com";
            link[0] = "http://news.liputan6.com/read/3121556/gagal-formula-1-rio-haryanto-jajal-balap-di-formula-e";

            judul[1] = "Jet Darat Formula 1 Tidak Pakai Sirip Hiu Musim Depan";
            sumber[1] = "http://otomotif.liputan6.com";
            link[1] = "http://otomotif.liputan6.com/read/3175493/jet-darat-formula-1-tidak-pakai-sirip-hiu-musim-depan";

            judul[2] = "Lewis Hamilton Sebut Regulasi F1 2018 Seperti Mengendarai Bus";
            sumber[2] = "http://otomotif.liputan6.com";
            link[2] = "http://otomotif.liputan6.com/read/3167667/lewis-hamilton-sebut-regulasi-f1-2018-seperti-mengendarai-bus";

            batasMaksimalBerita = 3;
            found = true;
        }

        if (message.contains("tenis")) {
            berita = "tenis";
            judul[0] = "Nadal dan Federer Kritik Aturan Baru di Australia Open";
            sumber[0] = "http://bola.liputan6.com";
            link[0] = "http://bola.liputan6.com/read/3172137/nadal-dan-federer-kritik-aturan-baru-di-australia-open";

            judul[1] = "Andy Murray Akhiri Kerja Sama dengan Sang Pelatih";
            sumber[1] = "http://bola.liputan6.com";
            link[1] = "http://bola.liputan6.com/read/3168230/andy-murray-akhiri-kerja-sama-dengan-sang-pelatih";

            judul[2] = "Petenis Tuna Rungu Korea Ramaikan Tenis Open di Jakarta";
            sumber[2] = "http://bola.liputan6.com";
            link[2] = "http://bola.liputan6.com/read/3165334/petenis-tuna-rungu-korea-ramaikan-tenis-open-di-jakarta";

            batasMaksimalBerita = 3;
            found = true;
        }

        if (message.contains("tenis meja")) {
            berita = "tenis meja";
            judul[0] = "Canggihnya Forpheus Robot Pengajar Tenis Meja Pertama di Dunia";
            sumber[0] = "http://tekno.liputan6.com";
            link[0] = "http://tekno.liputan6.com/read/3115703/photo-canggihnya-forpheus-robot-pengajar-tenis-meja-pertama-di-dunia?page=1";

            judul[1] = "Wajah Lucu Atlet Tenis Meja saat Bertanding di Sea Games 2017";
            sumber[1] = "http://bola.liputan6.com";
            link[1] = "http://bola.liputan6.com/read/3071497/photo-wajah-lucu-atlet-tenis-meja-saat-bertanding-di-sea-games-2017?page=1";

            judul[2] = "Ratusan Atlet Tenis Meja Ramaikan Turnamen Danrem 052/Wijayakrama";
            sumber[2] = "http://bola.liputan6.com";
            link[2] = "http://bola.liputan6.com/read/3064725/ratusan-atlet-tenis-meja-ramaikan-turnamen-danrem-052wijayakrama";

            batasMaksimalBerita = 3;
            found = true;
        }

        //end of section olahraga
        if (message.contains("politik")) {
            berita = "politik";
            judul[0] = "DPD Golkar Mengaku Solid Dukung Novanto Meski Berstatus " +
                    "Tersangka";
            sumber[0] = "news.detik.com";
            link[0] = "https://news.detik" +
                    ".com/berita/d-3723920/dpd-golkar-mengaku-solid-dukung" +
                    "-novanto-meski-berstatus-tersangka";

            batasMaksimalBerita = 1;
            found = true;
        }
        if (message.contains("gosip")) {
            berita = "gosip";
            judul[0] = "Jeje Govinda dan Syahnaz Sadiqah Mengaku Tegang saat " +
                    "Lamaran";
            sumber[0] = "showbiz.liputan6.com";
            link[0] = "http://showbiz" +
                    ".liputan6.com/read/3159984/jeje-govinda-dan-syahnaz" +
                    "-sadiqah-mengaku-tegang-saat-lamaran";
            batasMaksimalBerita = 1;
            found = true;
        }
        if (message.contains("kuliner")) {
            berita = "kuliner";
            judul[0] = "Menu Lezat Penghangat Tubuh di Musim Hujan";
            sumber[0] = "lifestyle.liputan6.com";
            link[0] = "http://lifestyle" +
                    ".liputan6.com/read/3157768/menu-lezat-penghangat-tubuh" +
                    "-di-musim-hujan";
            batasMaksimalBerita = 1;
            found = true;
        }
        if (message.contains("wisata")) {
            berita = "wisata";
            judul[0] = "Sensasi Menikmati Kopi di Atas Rakit Wisata Bahowo Manado";
            sumber[0] = "www.liputan6.com";
            link[0] = "http://regional" +
                    ".liputan6.com/read/3152431/sensasi-menikmati-kopi-di" +
                    "-atas-rakit-wisata-bahowo-manado";

            found = true;
        }
        if (message.contains("mancanegara")) {
            berita = "mancanegara";
            judul[0] = "Mendunia dan Diprotes, Patung Hitler di Museum Jogja " +
                    "Dihilangkan";
            sumber[0] = "international.sindonews.com";
            link[0] = "https://international.sindonews" +
                    ".com/read/1256545/40/mendunia-dan-diprotes-patung-hitler" +
                    "-di-museum-jogja-dihilangkan-1510392357";
            batasMaksimalBerita = 1;
            found = true;
        }

        if (message.contains("bisnis")) {
            berita = "bisnis";
            judul[0] = "Harga Emas Antam 2 Desember Dijual Rp620.000 per Gram";
            sumber[0] = "http://market.bisnis.com";
            link[0] = "http://market.bisnis.com/read/20171202/235/714507/harga-emas-antam-2-desember-dijual-rp620.000-per-gram";

            judul[1] = "IHSG Akan Bergerak Positif Pekan Depan";
            sumber[1] = "http://market.bisnis.com";
            link[1] = "http://market.bisnis.com/read/20171202/7/714477/ihsg-akan-bergerak-positif-pekan-depan";

            judul[2] = "Lelang Konservasi Untuk Para Petani dari Rejoso";
            sumber[2] = "http://industri.bisnis.com";
            link[2] = "http://industri.bisnis.com/read/20171202/99/714481/lelang-konservasi-untuk-para-petani-dari-rejoso-";

            judul[3] = "Pulau Seram Dilirik untuk Pengembangan Sektor Pertanian";
            sumber[3] = "http://industri.bisnis.com";
            link[3] = "http://industri.bisnis.com/read/20171201/99/714432/pulau-seram-ddilirik-untuk-pengembangan-sektor-pertanian";

            judul[4] = "Banyak Pengusaha Internasional Ingin Impor Ikan dari Perindo";
            sumber[4] = "http://industri.bisnis.com";
            link[4] = "http://industri.bisnis.com/read/20171201/99/714340/banyak-pengusaha-internasional-ingin-impor-ikan-dari-perindo";

            batasMaksimalBerita = 5;
            found = true;
        }

        if(message.contains("seni")) {
            berita = "seni";
            judul[0] = "Seniman Italia Ciptakan Mozaik dari Sisa Bahan Bangunan";
            sumber[0] = "http://global.liputan6.com";
            link[0] = "http://global.liputan6.com/read/3177793/video-seniman-italia-ciptakan-mozaik-dari-sisa-bahan-bangunan";

            judul[1] = "4 Kiat Memilih Pigura yang Tepat Agar Enak Dilihat";
            sumber[1] = "http://properti.liputan6.com";
            link[1] = "http://properti.liputan6.com/read/3171548/4-kiat-memilih-pigura-yang-tepat-agar-enak-dilihat";

            judul[2] = "Pria Ini Ciptakan Jam Tangan dari Kertas, Detailnya Bikin Takjub\n";
            sumber[2] = "http://citizen6.liputan6.com";
            link[2] = "http://citizen6.liputan6.com/read/3168956/pria-ini-ciptakan-jam-tangan-dari-kertas-detailnya-bikin-takjub";

            judul[3] = "Keren, Seniman Ini Gunakan Bibir Ciptakan Lukisan Menakjubkan";
            sumber[3] = "http://citizen6.liputan6.com";
            link[3] = "http://citizen6.liputan6.com/read/3133436/keren-seniman-ini-gunakan-bibir-ciptakan-lukisan-menakjubkan";

            batasMaksimalBerita = 4;
            found = true;
        }
        if(message.contains("kuliner")) {
            berita = "kuliner";
            judul[0] = "Sup Krim Wortel, Resep Lezat dan Sehat untuk Vegetarian";
            sumber[0] = "http://lifestyle.liputan6.com";
            link[0] = "http://lifestyle.liputan6.com/read/3179354/sup-krim-wortel-resep-lezat-dan-sehat-untuk-vegetarian";

            judul[1] = "4 Cara Zaman Now dan Seru Menyantap Pizza";
            sumber[1] = "http://lifestyle.liputan6.com";
            link[1] = "http://lifestyle.liputan6.com/read/3179171/4-cara-zaman-now-dan-seru-menyantap-pizza";

            judul[2] = "Seperti Ini Sebenarnya Pola Makan Bondan Winarno";
            sumber[2] = "http://health.liputan6.com";
            link[2] = "http://health.liputan6.com/read/3179294/seperti-ini-sebenarnya-pola-makan-bondan-winarno";

            batasMaksimalBerita = 3;
            found = true;
        }

        if(message.contains("hobi")) {
            berita = "hobi";
            judul[0] = "Tak Sekadar Hobi, Ini 6 Aktivitas untuk Tingkatkan Daya Pikirmu";
            sumber[0] = "http://citizen6.liputan6.com";
            link[0] = "http://citizen6.liputan6.com/read/3165278/tak-sekadar-hobi-ini-6-aktivitas-untuk-tingkatkan-daya-pikirmu";

            judul[1] = "Hobi Traveling? Ini Pekerjaan yang Cocok untuk Anda";
            sumber[1] = "http://lifestyle.liputan6.com";
            link[1] = "http://lifestyle.liputan6.com/read/3141031/hobi-traveling-ini-pekerjaan-yang-cocok-untuk-anda";

            judul[2] = "Hobi Ini Bisa Hasilkan Uang Jika Anda Mau Tekuni";
            sumber[2] = "http://bisnis.liputan6.com";
            link[2] = "http://bisnis.liputan6.com/read/3109756/hobi-ini-bisa-hasilkan-uang-jika-anda-mau-tekuni";

            batasMaksimalBerita = 3;
            found = true;
        }

        if(message.contains("teknologi")) {
            berita = "teknologi";
            judul[0] = "Google Rilis Aplikasi Android Datally yang Bisa Pantau Penggunaan Data";
            sumber[0] = "https://www.beritateknologi.com";
            link[0] = "https://www.beritateknologi.com/google-rilis-aplikasi-android-datally-yang-bisa-pantau-penggunaan-data/ ";

            judul[1] = "Oppo A83 Akan Segera Diumumkan dengan Display 18:9 dan CPU Octa-Core\n";
            sumber[1] = "https://www.beritateknologi.com/";
            link[1] = "https://www.beritateknologi.com/oppo-a83-akan-segera-diumumkan-dengan-display-189-dan-cpu-octa-core/";

            judul[2] = "Rincian Mengenai Snapdragon 845 Telah Terungkap, Masih Gunakan Proses 10nm";
            sumber[2] = "https://www.beritateknologi.com";
            link[2] = "https://www.beritateknologi.com/rincian-mengenai-snapdragon-845-telah-terungkap-masih-gunakan-proses-10nm/";

            batasMaksimalBerita = 3;
            found = true;
        }

        if(message.contains("nasional")) {
            berita = "nasional";
            judul[0] = "Mendagri: Jangan Sampai Program Presiden di DKI Terhambat karena Program Lain";
            sumber[0] = "http://nasional.kompas.com";
            link[0] = "http://nasional.kompas.com/read/2017/11/29/17431161/mendagri-jangan-sampai-program-presiden-di-dki-terhambat-karena-program-lain";

            judul[1] = "Geledah 3 Tempat di Jambi, KPK Sita Dokumen Pembahasan Anggaran";
            sumber[1] = "http://nasional.kompas.com";
            link[1] = "http://nasional.kompas.com/read/2017/12/02/11313721/geledah-3-tempat-di-jambi-kpk-sita-dokumen-pembahasan-anggaran";

            judul[2] = "Bungkukkan Badan, Jokowi Beri Hormat ke Puluhan Ribu Guru";
            sumber[2] = "http://nasional.kompas.com";
            link[2] = "http://nasional.kompas.com/read/2017/12/02/10490751/bungkukkan-badan-jokowi-beri-hormat-ke-puluhan-ribu-guru";

            batasMaksimalBerita = 3;
            found = true;
        }

        if(message.contains("kesehatan")) {
            berita = "kesehatan";
            judul[0] = "Manfaat Kopi Lebih Banyak dari Bahayanya, Ini Bukti Ilmiahnya";
            sumber[0] = "http://global.liputan6.com";
            link[0] = "http://global.liputan6.com/read/3173337/manfaat-kopi-lebih-banyak-dari-bahayanya-ini-bukti-ilmiahnya";

            judul[1] = "Waspada, Warna Kotoran Telinga Tunjukkan Kondisi Kesehatanmu";
            sumber[1] = "http://citizen6.liputan6.com";
            link[1] = "http://citizen6.liputan6.com/read/3170808/waspada-warna-kotoran-telinga-tunjukkan-kondisi-kesehatanmu";

            judul[2] = "Berbagai Warna Kotoran Telinga dan Artinya Bagi Kesehatan";
            sumber[2] = "http://health.liputan6.com";
            link[2] = "http://health.liputan6.com/read/3168152/berbagai-warna-kotoran-telinga-dan-artinya-bagi-kesehatan";

            batasMaksimalBerita = 3;
            found = true;
        }

        if(message.contains("pekerjaan")) {
            berita = "pekerjaan";
            judul[0] = "Lagi Cari Kerja? 9 Lowongan Ini Bisa Anda Coba";
            sumber[0] = "http://bisnis.liputan6.com";
            link[0] = "http://bisnis.liputan6.com/read/3178695/lagi-cari-kerja-9-lowongan-ini-bisa-anda-coba";

            judul[1] = "Ada Lowongan Kerja Terbaru di BRI, Ini Syaratnya";
            sumber[1] = "http://bisnis.liputan6.com";
            link[1] = "http://bisnis.liputan6.com/read/3172648/ada-lowongan-kerja-terbaru-di-bri-ini-syaratnya";

            judul[2] = "Pertamina Kembali Buka Lowongan Kerja, Mau?";
            sumber[2] = "http://bisnis.liputan6.com";
            link[2] = "http://bisnis.liputan6.com/read/3171623/pertamina-kembali-buka-lowongan-kerja-mau";

            batasMaksimalBerita = 3;
            found = true;
        }

        // based on search key
        if (message.contains("setya") && message.contains("novanto")) {
            berita = "Setya Novanto";
            judul[0] = "Setya Novanto Akan Minta Perlindungan Jokowi jika " +
                    "Dipanggil KPK";
            sumber[0] = "nasional.tempo.co";
            link[0] = "https://nasional.tempo" +
                    ".co/read/1033078/setya-novanto-akan-minta-perlindungan" +
                    "-jokowi-jika-dipanggil-kpk";

            judul[1] = "Ketika Setya Novanto Curhat Soal Obat dan Makanan Di Tahanan KPK";
            sumber[1] = "http://www.tribunnews.com";
            link[1] = "http://www.tribunnews.com/nasional/2017/12/01/ketika-setya-novanto-curhat-soal-obat-dan-makanan-di-tahanan-kpk";

            judul[2] = "Andi Narogong Akhirnya Buka 6 Fakta Peran Setya Novanto Pada Kasus KTP Elektronik";
            sumber[2] = "http://www.tribunnews.com";
            link[2] = "http://www.tribunnews.com/nasional/2017/12/01/andi-narogong-akhirnya-buka-6-fakta-peran-setya-novanto-pada-kasus-ktp-elektronik";

            judul[3] = "Khawatir Kubu Pro Novanto Gagalkan Munaslub, Doli Wanti-wanti DPD I";
            sumber[3] = "http://nasional.kompas.com";
            link[3] = "http://nasional.kompas.com/read/2017/12/01/22293771/khawatir-kubu-pro-novanto-gagalkan-munaslub-doli-wanti-wanti-dpd-i";

            batasMaksimalBerita = 4;
            found = true;
        }
        if (message.contains("chelsea")) {
            berita = "chelsea";
            judul[0] = "Why Rafa Benitez will never be accepted at Chelsea as he makes his return with Newcastle";
            sumber[0] = "http://www.goal.com";
            link[0] = "http://www.goal.com/en-gb/news/why-rafa-benitez-will-never-be-accepted-at-chelsea-as-he/5hmkxansuy3n1pt3beaym7cbd";

            judul[1] = "New Everton manager Sam Allardyce gives Ross Barkley update with Chelsea and Spurs still keen";
            sumber[1] = "http://www.football.london";
            link[1] = "http://www.football.london/chelsea-fc/transfer-news/barkley-future-everton-allardyce-chelsea-13982205";

            judul[2] = "Tak Selalu Jadi Starter di Chelsea, Ruediger Pahami Kondisi";
            sumber[2] = "http://bola.kompas.com";
            link[2] = "http://bola.kompas.com/read/2017/12/01/19300038/tak-selalu-jadi-starter-di-chelsea-ruediger-pahami-kondisi";
            batasMaksimalBerita = 3;
            found = true;
        }

        if (found) {
            int i;
            for(i=0;i<Math.min(3, batasMaksimalBerita);i++) {
                if(i==0) {
                    response ="<h4>Berikut berita " +
                            berita +
                            " terkini:</h4>";
                }
                response +=
                        judul[i] +
                        "<p style='color:#7f8c8d'><small>(sumber: " +
                        sumber[i] +
                        ")</small></p>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; " +
                        " <b>Kepo? </b><a href='" +
                        link[i] +
                        "'>Baca disini</a><br><br>";
            }
            indeksBerita = Math.min(3, batasMaksimalBerita);
            found = false;
        }

        return response;
    }
}
