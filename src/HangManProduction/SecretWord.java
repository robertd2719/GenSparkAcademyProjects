package HangManProduction;

import java.util.Random;

public class SecretWord {
    private final String [] wordBank;
    private final String secretWord;

    public SecretWord(){
        Random random = new Random();
        this.wordBank = new String[]{"MONEY","TIME","SPACE","CORN","BALL","FOX"};
        this.secretWord = this.wordBank[random.nextInt(this.wordBank.length)];
        System.out.println("SECRET WORD CREATED: "+this.secretWord);

    }

    public String getSecretWord() {
        return secretWord;
    }
}
