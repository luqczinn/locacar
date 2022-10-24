package locadora.locadora.negocio.servico;

import locadora.locadora.negocio.excessoes.negocioException;
import java.sql.SQLException;
import java.util.List;
import locadora.locadora.negocio.dao.ReservasDAO;
import locadora.locadora.negocio.dto.Reservas;

public class ServicoReservas {

    public ServicoReservas() {
    }

    public static Reservas inserirReservaBD(Integer codigo, String cliente, String vendedor, String veiculo, String unidade, String inicio, String fim, String valorDiaria, String valorReserva) throws negocioException, SQLException {
        if (codigo < 0) {
            throw new negocioException(419, "Preencha o código corretamente.");
        }
        if (cliente.isEmpty()) {
            throw new negocioException(419, "Preencha o campo 'cliente' corretamente.");
        }
        if (vendedor.isEmpty()) {
            throw new negocioException(419, "Preencha o campo 'vendedor' corretamente.");
        }
        if (veiculo.isEmpty()) {
            throw new negocioException(419, "Preencha o campo 'veiculo' corretamente.");
        }
        if (unidade.isEmpty()) {
            throw new negocioException(419, "Preencha o campo 'unidade' corretamente.");
        }
        if (inicio.isEmpty()) {
            throw new negocioException(419, "Preencha o campo 'inicio' corretamente.");
        }
        if (fim.isEmpty()) {
            throw new negocioException(419, "Preencha o campo 'fim' corretamente.");
        }
        if (valorDiaria.isEmpty()) {
            throw new negocioException(419, "Preencha o campo 'valorDiaria' corretamente.");
        }
        if (valorReserva.isEmpty()) {
            throw new negocioException(419, "Preencha o campo 'valorReserva' corretamente.");
        }
        return ReservasDAO.cadastrarReservasBD(codigo, cliente, vendedor, veiculo, unidade, inicio, fim, valorDiaria, valorReserva);
    }
    
    public static Reservas removerReservaPorCodigo(Integer codigo) throws negocioException, SQLException{
        if(codigo==0)
            throw new negocioException (419, "Informe o código da reserva corretamente.");
        
        return ReservasDAO.removerReservaBD(codigo);
    }
    public static List<Reservas> listarReservas() throws negocioException, SQLException{
        if(ReservasDAO.listarReservasBD() == null)
            throw new negocioException (415, "Não existem reservas cadastrados!");
        
        return ReservasDAO.listarReservasBD();
    }
    public static Reservas consultarPorCodigo(Integer codigo) throws negocioException, SQLException{
        
        if(codigo==0)
            throw new negocioException(419, "Insira o codigo da reserva!");
        
        return ReservasDAO.consultarPorCodigo(codigo);
    }
    public static Reservas consultarPorCliente(String cliente) throws negocioException, SQLException{
        
        if(cliente.isEmpty())
            throw new negocioException(419, "Insira o nome do cliente!");
        
        return ReservasDAO.consultarPorCliente(cliente);
    }
    
}
