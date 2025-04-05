package Firmas;
public class TramitesFirmasLG {
        private String cer;
        private String key;

        // Constructor que acepta las rutas del cer y key
        public TramitesFirmasLG(String cer, String key) {
            this.cer = cer;
            this.key = key;
        }

        // Métodos para obtener las rutas del cer y key
        public String getCer() {return cer;}
        public String getKey() {return key;}
    }

