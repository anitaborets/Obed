package com.engeto;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws Exception{
	Filozof [] filozofs = new Filozof[10];
	Spoon[] spoons = new Spoon[10];

	for(int i = 0; i < 10; i++){
	    spoons[i] = new Spoon();
    }

	for (int i = 0; i < 10; i++){
	    Spoon right = spoons[i];
	    Spoon left = spoons[(i+1)%10];

	    if(i == 9){
			filozofs[i] = new Filozof(i, right,left);
		}
	    else{
			filozofs[i] = new Filozof(i, left, right);
		}


	    Thread thread = new Thread(filozofs[i]);
	    thread.start();
    }

    }
}
