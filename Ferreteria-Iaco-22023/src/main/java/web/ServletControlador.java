package web;

import data.FerreteriaDAO;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import model.*;

@WebServlet("/servletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String accion = req.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "eliminar":
                    eliminarTornillo(req, res);
                    break;
                case "editar":
                    editarTornillo(req, res);
                    break;
                case "visualizarEliminados":
                    visualizarEliminados(req, res);
                    break;
                case "reactivar":
                    reactivarTornillo(req, res);
                    break;
                default:
                    accionDefault(req, res);
                    break;
            }
        } else {
            accionDefault(req, res);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String queryParam = req.getParameter("accion");
        if (queryParam != null) {
            switch (queryParam) {
                case "insertar":
                    insertarTornillo(req, res);
                    break;
                case "actualizarStock":
                    updateStock(req, res);
                    break;
                case "modificar":
                    String subAccion = req.getParameter("btnAccion");
                    switch (subAccion) {
                        case "Modificar":
                            // System.out.println("Sub accion Modificar");
                            modificarTornillo(req, res);
                            break;
                        case "Eliminar":
                            // System.out.println("Sub accion Eliminar");
                            eliminarTornillo(req, res);
                            break;
                        default:
                            // System.out.println("Sub accion Cancelar");
                            accionDefault(req, res);
                            break;
                    }
                    // System.out.println("Sub accion nada");
                    break;
                default:
                    accionDefault(req, res);
                    break;
            }
        }
    }

    private void accionDefault(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Ferreteria> tornillos = new FerreteriaDAO().findAll();
        tornillos.forEach(System.out::println);
        HttpSession sesion = req.getSession();
        sesion.setAttribute("tornillos", tornillos);
        sesion.setAttribute("cantidadTornillos", calcularStock(tornillos));
        sesion.setAttribute("precioTotal", calcularPrecio(tornillos));
        res.sendRedirect("tornillos.jsp");
    }

    private void visualizarEliminados(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Ferreteria> tornillos = new FerreteriaDAO().findAllDeleted();
        System.out.println("Se muestran eliminados...");
        tornillos.forEach(System.out::println);
        HttpSession sesion = req.getSession();
        sesion.setAttribute("tornillos", tornillos);
        res.sendRedirect("tornillosEliminados.jsp");
    }

    private void insertarTornillo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String codigoSku = req.getParameter("codigoSku");
        String descripcion = req.getParameter("descripcion");
        String pesoUnidadStr = req.getParameter("pesoUnidad");
        int pesoUnidad = 0;
        if (!"".equals(pesoUnidadStr)) {
            pesoUnidad = Integer.parseInt(pesoUnidadStr);
        }
        double precio = Double.parseDouble(req.getParameter("precio"));
        int stock = Integer.parseInt(req.getParameter("stock"));

        Ferreteria tornillo = new Ferreteria(codigoSku, descripcion, pesoUnidad, precio, stock);
        int registrosMod = new FerreteriaDAO().insert(tornillo);
        System.out.println("insertados = " + registrosMod);

        accionDefault(req, res);
    }

    private void editarTornillo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int idTornillo = Integer.parseInt(req.getParameter("idtornillo"));
        System.out.println("registro = " + idTornillo);

        Ferreteria tornillo = new FerreteriaDAO().findById(idTornillo);
        req.setAttribute("tornillo", tornillo);
        String jspEditar = "/WEB-INF/paginas/operaciones/editar.jsp";
        req.getRequestDispatcher(jspEditar).forward(req, res);
        res.sendRedirect("tornillos.jsp");
    }

    private void modificarTornillo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("recibido: " + req.toString());

        String button = req.getParameter("buttonPressed");
        System.out.println("button" + button);

        int idTornillo = Integer.parseInt(req.getParameter("idtornillo"));
        String codigoSku = req.getParameter("codigoSku");
        String descripcion = req.getParameter("descripcion");
        String pesoUnidadStr = req.getParameter("pesoUnidad");
        int pesoUnidad = 0;
        if (!"".equals(pesoUnidadStr)) {
            pesoUnidad = Integer.parseInt(pesoUnidadStr);
        }
        double precio = Double.parseDouble(req.getParameter("precio"));
        int stock = Integer.parseInt(req.getParameter("stock"));

        Ferreteria tornillo = new Ferreteria(idTornillo, codigoSku, descripcion, pesoUnidad, precio, stock);
        int registrosMod = new FerreteriaDAO().updateTornillo(tornillo);
        System.out.println("modificados = " + registrosMod);
        accionDefault(req, res);
    }

    private void eliminarTornillo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int idTornillo = Integer.parseInt(req.getParameter("idtornillo"));
        Ferreteria tornillo = new Ferreteria(idTornillo);
        int registrosDel = new FerreteriaDAO().deleteTornillo(tornillo);
        System.out.println("eliminados = " + registrosDel);
        accionDefault(req, res);
    }

    private void updateStock(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int idTornillo = Integer.parseInt(req.getParameter("idtornillo"));
        int stock = Integer.parseInt(req.getParameter("stock"));
        Ferreteria tornillo = new Ferreteria(idTornillo, stock);
        int registrosDel = new FerreteriaDAO().updateStock(tornillo);
        System.out.println("eliminados = " + registrosDel);
        accionDefault(req, res);
    }

    private void reactivarTornillo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int idTornillo = Integer.parseInt(req.getParameter("idtornillo"));
        System.out.println("Reactivando tornillo " + idTornillo);
        Ferreteria tornillo = new Ferreteria(idTornillo);
        int registrosDel = new FerreteriaDAO().reactivaTornillo(tornillo);
        System.out.println("reactivado = " + registrosDel);
        visualizarEliminados(req, res);
    }

    private int calcularStock(List<Ferreteria> lib) {
        int cant = 0;
        for (int i = 0; i < lib.size(); i++) {
            cant += lib.get(i).getStock();
        }
        return cant;
    }

    private double calcularPrecio(List<Ferreteria> lib) {
        double precio = 0;
        for (int i = 0; i < lib.size(); i++) {
            precio += (lib.get(i).getPrecio() * lib.get(i).getStock());
        }
        return precio;
    }
}
