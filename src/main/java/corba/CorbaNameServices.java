package main.java.corba;

//
// Classe ServicoNomes
//   Esta classe permite a insercao e consulta de objetos no servico
//    de nomes CORBA
// Sergio Teixeira de Carvalho 
//

import java.util.Properties;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;

import _McDonaldsCorbaPackage.McDonaldsCorba;
import _McDonaldsCorbaPackage.McDonaldsCorbaHelper;

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
          throw new RuntimeException(e.getMessage(), e);
       }
   }


// Metodo consultaObjeto(). Este metodo e' invocado pelo cliente ou pelo 
//  servidor com o objetivo de encontrar um objeto no servico de nomes CORBA

	public McDonaldsCorba consultaObjeto() throws Exception {
		McDonaldsCorba refObjeto = null;
		Properties props = new Properties();
		props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
		props.setProperty("org.omg.CORBA.ORBInitialPort", "1070");
		ORB orb = ORB.init(args, props);
		org.omg.CORBA.Object objRef = orb
				.resolve_initial_references("NameService");
		NamingContext ncRef = NamingContextHelper.narrow(objRef);
		NameComponent nc1 = new NameComponent(idObjeto, "");
		NameComponent path[] = { nc1 };
		refObjeto = McDonaldsCorbaHelper.narrow(ncRef.resolve(path));
		return (refObjeto);
	}
}