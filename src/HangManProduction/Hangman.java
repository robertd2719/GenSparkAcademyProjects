package HangManProduction;

public class Hangman {
    int count = 0;
    String [] hangManArray = new String[8];

    public Hangman(){
        this.hangManArray[0] ="+- - - - - - - +";
        this.hangManArray[1] = "                |";
        this.hangManArray[2] = "                |";
        this.hangManArray[3] = "                |";
        this.hangManArray[4] = "                |";
        this.hangManArray[5] = "                |";
        this.hangManArray[6] = "                |";
        this.hangManArray[7] = "==============+";
    }

        public void updateHangman(){
            this.count++;
            StringBuilder sb = new StringBuilder();
            switch(count){
                case 1:
                    //
                    sb.append(this.hangManArray[1]);
                    sb.setCharAt(4,'|');
                    this.hangManArray[1] = sb.toString();
                    break;
                case 2:
                    sb.append(this.hangManArray[2]);
                    sb.setCharAt(4,'O');
                    this.hangManArray[2] = sb.toString();
                    break;
                case 3:
                    sb.append(this.hangManArray[3]);
                    sb.setCharAt(4,'|');
                    this.hangManArray[3] = sb.toString();
                    break;
                case 4:
                    sb.append(this.hangManArray[4]);
                    sb.setCharAt(4,'|');
                    this.hangManArray[4] = sb.toString();
                    break;
                case 5:
                    sb.append(this.hangManArray[5]);
                    sb.setCharAt(3,'/');
                    this.hangManArray[5] = sb.toString();
                    break;
                case 6:
                    sb.append(this.hangManArray[3]);
                    sb.setCharAt(5, '\\');
                    this.hangManArray[3] = sb.toString();
                    break;
                case 7:
                    sb.append(this.hangManArray[5]);
                    sb.setCharAt(5,'\\');
                    this.hangManArray[5] = sb.toString();
                    break;
                case 8:
                    sb.append(this.hangManArray[3]);
                    sb.setCharAt(3,'/');
                    this.hangManArray[3] = sb.toString();
            }
        }
        public void drawHangman(){
            for(String item: hangManArray){
                System.out.println(item);
            }
        }


}
