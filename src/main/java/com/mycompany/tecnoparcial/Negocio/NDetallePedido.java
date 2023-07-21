package com.mycompany.tecnoparcial.Negocio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import com.mycompany.tecnoparcial.Datos.DDetallePedido;
import com.mycompany.tecnoparcial.Datos.Tabla;

public class NDetallePedido extends Negocio {
    public NDetallePedido() {
        super(new DDetallePedido());
    }

    public String listar(String id) throws IOException{
        if (!validarInteger(id)) {
            return "Debe introducir un id del pedido";
        }
        DDetallePedido dDetallePedido = (DDetallePedido) this.dato;
        Tabla datos = dDetallePedido.listar(id);
        return listarDinamico("Detalle de Pedido", datos);
    }

    public String obtenerProductosPopulares() throws IOException {
        DDetallePedido dDetallePedido = (DDetallePedido) this.dato;
        Tabla datos = dDetallePedido.obtenerProductosPopulares();
        String html = listarDinamico("Productos Populares", datos);
        return html + "\n" + generarPieChart(datos);
    }

    private String generarPieChart(Tabla datos) {
        DefaultPieDataset<String> pieChart = new DefaultPieDataset<>();
        int total = 0;
        for (int i = 0; i < datos.getFila(); i++) {
            total += Integer.parseInt(datos.getData(i, 1));
        }
        for (int i = 0; i < datos.getFila(); i++) {
            int porcentaje = Math.round((Integer.parseInt(datos.getData(i, 1)) * 100.0f) / total);
            pieChart.setValue(datos.getData(i, 0) +" "+ porcentaje + "%", Double.parseDouble(datos.getData(i, 1)));
        }
        JFreeChart grafico = ChartFactory.createPieChart("Productos Populares", pieChart, true, true, false);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            ChartUtils.writeChartAsPNG(outputStream, grafico, 500, 300);
        } catch (Exception e) {
            return "No se pudo generar las estadisticas";
        }

        // Convertir la imagen a base64 para incluirla en el HTML
        byte[] imageBytes = outputStream.toByteArray();
        String base64Image = Base64.getEncoder().encodeToString(imageBytes);
        String response = "<img style=\"display: block; margin: auto;\" src=\"data:image/png;base64," + base64Image
                + "\"/>";
        return response;
    }
}
