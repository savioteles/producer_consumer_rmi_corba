package main.java.corba;

//
// Classe ServicoNomes
//   Esta classe permite a insercao e consulta de objetos no servico
//    de nomes CORBA
// Sergio Teixeira de Carvalho 
//

import org.omg.CosNaming.*;
import org.omg.CORBA.*;

import _McDonaldsCorbaPackage.McDonaldsCorba;
import _McDonaldsCorbaPackage.McDonaldsCorbaHelper;

import java.util.Properties;

public class CorbaNameServices {


  String idObjeto;      // Identificacao do objeto CORBA

   String[] args = {};  



// Metodo construtor. Cada instancia deve ter sua identificacao
 
   public CorbaNameServices (String aIdObjeto) {
     idObjeto = aIdObjeto;
   }


// Metodo insereObjeto(). Este metodo e' invocado pelo servidor com o 
//  objetivo de ser inserido no servico de nomes CORBA

   public void insereObjeto(McDonaldsImplCorba aServant) { 
      try {
         Properties props = new Properties(); 
         props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
         props.setProperty("org.omg.CORBA.ORBInitialPort", "1070");
         ORB orb = ORB.init(args, props);  
         orb.connect (aServant);
         org.omg.CORBA.Object objRef = 
                  orb.resolve_initial_references ("NameService");
         NamingContext ncRef = NamingContextHelper.narrow(objRef);
         NameComponent nc1 = new NameComponent (idObjeto, "");
         NameComponent path[] = {nc1};
         ncRef.rebind (path, aServant);
       }
       catch (Exception e) {
          System.out.println ("Erro: " + idObjeto + " " + e);
          e.printStackTrace(System.out);
       }
   }


// Metodo consultaObjeto(). Este metodo e' invocado pelo cliente ou pelo 
//  servidor com o objetivo de encontrar um objeto no servico de nomes CORBA

   public McDonaldsCorba consultaObjeto() {
	   McDonaldsCorba refObjeto = null;
      try {
         Properties props = new Properties();
         props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
         props.setProperty("org.omg.CORBA.ORBInitialPort", "1070");
         ORB orb = ORB.init(args, props);
         org.omg.CORBA.Object objRef = 
                orb.resolve_initial_references("NameService");
         NamingContext ncRef = NamingContextHelper.narrow(objRef);
         NameComponent nc1 = new NameComponent (idObjeto, "");
         NameComponent path[] = {nc1};
         refObjeto = McDonaldsCorbaHelper.narrow (ncRef.resolve(path));
       }
     catch (Exception e) {
          System.out.println ("Erro: "  + idObjeto + " " + e);
          e.printStackTrace(System.out);
     }
     return (refObjeto);
   }
}