public class Main {

    public static void executeMy() throws Exception {
        ;
        throw new Exception("error");
    }

    public static void main(String[] args) {

            Exception ex1 = new Exception();

            Exception ex2 = new Exception("Popis výjimky.");

            String msg1 = ex1.getMessage();
            String msg2 = ex2.getMessage();

            try {
                executeMy();
            }
            catch (Exception e) {
                String msg = e.getMessage();
            }

        }
    }
}