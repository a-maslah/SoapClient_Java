package test;

import ws.BanqueService;
import ws.BanqueWS;
import ws.Compte;

import java.util.List;

public class ClientWS {

    public static void main(String[] args) {
        BanqueService proxyWS = new BanqueWS().getBanqueServicePort();
        System.out.println(proxyWS.conversionEuroToDH(20));

        double res = proxyWS.conversionEuroToDH(980);
        System.out.println(res);

        Compte compte =  proxyWS.getCompte(1L);
        System.out.println("Code"+compte.getCode()+",   "+"Solde"+compte.getSolde()+",  "+"Active"+compte.isActive());


        List<Compte> compteList = proxyWS.listeComptes();
        for(Compte c:compteList){
            System.out.println(c.getCode()+"  "+c.getSolde()+"  "+c.isActive());
        }
    }
}
