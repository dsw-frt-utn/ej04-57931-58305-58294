package views;

import data.Persistencia;
import domain.Marca;
import domain.Sucursal;
import domain.Vehiculo;
import domain.VehiculoCombustible;
import domain.VehiculoElectrico;
import domain.VehiculoTipo;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import javax.swing.JOptionPane;

public class Controlador {
    
    public static ArrayList<VehiculoViewModel> getVehiculos(){
        ArrayList<VehiculoViewModel> vehiculos = new ArrayList<>();
        for(Vehiculo vehiculo : Persistencia.getVehiculos()) {
            vehiculos.add(new VehiculoViewModel(vehiculo));
        }
        return vehiculos;
    }
    
     public static void Cerrar2(AgregarVehiculo a){
        a.dispose();
    
     }
    
    
    
         public static void Cerrar3(ListarVehiculosView l){
        l.dispose();
        
     }
    
    public static double[] calcularConsumos(Map<String, Double> vehiculos){
        double consumoElectricos = 0;
        double consumoCombustible= 0;
        for(Map.Entry<String, Double> entry : vehiculos.entrySet()){
           double consumo = 0;
           Optional<Vehiculo> vehiculo = Persistencia.getVehiculo(entry.getKey());
           if(vehiculo.isPresent()){
               consumo = vehiculo.get().calcularConsumo(entry.getValue());
               consumoElectricos += vehiculo.get().esDe(VehiculoTipo.ELECTRICO) ? consumo : 0;
               consumoCombustible += vehiculo.get().esDe(VehiculoTipo.COMBUSTIBLE) ? consumo : 0;
           }
        }
        return new double[] {consumoElectricos, consumoCombustible};
    }
    
    
     public static void Agregar (AgregarVehiculo agv){
         
        try{
        String patente = agv.getPatente().getText();
        String marca = agv.getMarcas().getSelectedItem().toString();
        String modelo = agv.getModelo().getText();
        int tipo = agv.getTipo().getSelectedIndex();
        String sucursal = agv.getSucursal().getSelectedItem().toString();
        double capcar = Double.parseDouble(agv.getCapacidad().getText());
        int anio = Integer.parseInt(agv.getAnio().getText());
        double kmRec = Double.parseDouble(agv.getKmrec().getText());
        double kmL = Double.parseDouble(agv.getKmlit().getText());
        double litrosEx = Double.parseDouble(agv.getLitrosextra().getText());
        
        Marca m = new Marca(marca);
        Sucursal s = new Sucursal(sucursal);
         JOptionPane.showMessageDialog(agv, "Vehiculo cargado"," Mensaje ",JOptionPane.CLOSED_OPTION);

        switch (tipo) {
            case 0:
                VehiculoCombustible vc = new VehiculoCombustible(patente, m, modelo, anio, capcar, s, kmL, litrosEx,kmRec);
                Persistencia.getVehiculos().add(vc);
                break;
            case 1:
                VehiculoElectrico ve = new VehiculoElectrico(patente, m, modelo, anio, capcar, s, 16,kmRec);
                Persistencia.getVehiculos().add(ve);
                break;
            default:
                throw new AssertionError();
        }    
    
             agv.getPatente().setText("");
             agv.getModelo().setText("");
             agv.getCapacidad().setText("");
             agv.getAnio().setText("");
             agv.getKmlit().setText("");
             agv.getKmrec().setText("");
             agv.getLitrosextra().setText("");
             
                    
     } catch (Exception e){
            JOptionPane.showMessageDialog(agv,"Error en algun dato","Error",JOptionPane.ERROR_MESSAGE);
            System.out.println("ERROR:"+e);
        }
        
        
        
         }
    
    
    
    
    
}
