package fr.cytech.cy_crypto.component;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class CurrencyInformationThread extends Thread{

    private CurrencyInformationThread(){
        
    }

    @PostConstruct
    private void init() {
        this.start();
    }
    
    @Override
    public void run() {
        System.out.println("CurrencyInformationThread");
    }
}
