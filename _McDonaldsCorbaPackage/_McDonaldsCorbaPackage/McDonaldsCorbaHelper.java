package _McDonaldsCorbaPackage;


/**
* _McDonaldsCorbaPackage/McDonaldsCorbaHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from src/main/java/corba/McDonaldsCorba.idl
* Segunda-feira, 2 de Junho de 2014 22h22min27s BRT
*/

abstract public class McDonaldsCorbaHelper
{
  private static String  _id = "IDL:McDonaldsCorbaPackage/McDonaldsCorba:1.0";

  public static void insert (org.omg.CORBA.Any a, _McDonaldsCorbaPackage.McDonaldsCorba that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static _McDonaldsCorbaPackage.McDonaldsCorba extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (_McDonaldsCorbaPackage.McDonaldsCorbaHelper.id (), "McDonaldsCorba");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static _McDonaldsCorbaPackage.McDonaldsCorba read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_McDonaldsCorbaStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, _McDonaldsCorbaPackage.McDonaldsCorba value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static _McDonaldsCorbaPackage.McDonaldsCorba narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof _McDonaldsCorbaPackage.McDonaldsCorba)
      return (_McDonaldsCorbaPackage.McDonaldsCorba)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      _McDonaldsCorbaPackage._McDonaldsCorbaStub stub = new _McDonaldsCorbaPackage._McDonaldsCorbaStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static _McDonaldsCorbaPackage.McDonaldsCorba unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof _McDonaldsCorbaPackage.McDonaldsCorba)
      return (_McDonaldsCorbaPackage.McDonaldsCorba)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      _McDonaldsCorbaPackage._McDonaldsCorbaStub stub = new _McDonaldsCorbaPackage._McDonaldsCorbaStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}