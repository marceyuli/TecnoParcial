package com.mycompany.tecnoparcial.Negocio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import com.mycompany.tecnoparcial.Datos.DProducto;
import com.mycompany.tecnoparcial.Datos.Tabla;

public class NProducto extends Negocio {
    public NProducto() {
        super(new DProducto());
    }

    public String obtenerProductosPorCategoria(String categoriaid) throws IOException{
        DProducto dProducto = (DProducto) this.dato;
        Tabla datos = dProducto.obtenerProductosPorCategoria(categoriaid);
        return listarDinamico("Productos por categoria", datos);
    }

    public String obtenerProductosReabastecimiento() throws IOException{
        DProducto dProducto = (DProducto) this.dato;
        Tabla datos = dProducto.obtenerProductosReabastecimiento();
        return listarDinamico("Productos a Reabastecer", datos);
    }

    public String obtenerStock() throws IOException {
        Tabla datos = this.dato.listar();
        String html = listarDinamico("Stock", datos);
        return html + "\n" + generarPieChart(datos);
    }

    private String generarPieChart(Tabla datos) {
        DefaultPieDataset<String> pieChart = new DefaultPieDataset<>();
        int total = 0;
        for (int i = 0; i < datos.getFila(); i++) {
            total += Integer.parseInt(datos.getData(i, 5));
        }
        for (int i = 0; i < datos.getFila(); i++) {
            int porcentaje = Math.round((Integer.parseInt(datos.getData(i, 5)) * 100.0f) / total);
            pieChart.setValue(datos.getData(i, 3) +" "+ porcentaje + "%", Double.parseDouble(datos.getData(i, 5)));
        }
        JFreeChart grafico = ChartFactory.createPieChart("Stock", pieChart, true, true, false);

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
