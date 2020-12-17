package tp.Gestores;

import java.util.ArrayList;
import java.util.List;

import tp.DAO.FixtureDAO;
import tp.DTOs.CompetenciaDTO;
import tp.DTOs.FixtureDTO;
import tp.DTOs.PartidoDTO;
import tp.clases.Competencia;
import tp.clases.Fecha;
import tp.clases.Fixture;
import tp.clases.ItemLugar;
import tp.clases.Participante;
import tp.clases.Partido;
import tp.enums.EstadoCompetencia;
import tp.enums.Modalidad;

public class GestorFixture {

	private FixtureDAO fixtureDao = new FixtureDAO();
	
	
public static Fixture generarFixture(Competencia competencia) {
		
		List<Fecha> fechas= new ArrayList<Fecha>();
		List<Partido> partidos=new ArrayList<Partido>();
		List<Participante> participantes= competencia.getParticipantes();
		List<ItemLugar> lugares= competencia.getLugares();
		List<PartidoTemp> partidosTemp= calcularPartidos(participantes);
		Integer divisor = participantes.size();
		if(participantes.size()%2 == 0) {
			divisor = (participantes.size()-1);
		}
		
		Fecha fecha;
		int lugarActual=0;
		int contLugarActual=0;
		int contFechas=1;
		int contPartidos=0;
		for(PartidoTemp p : partidosTemp) {
			partidos.add(new Partido(p.local,p.visitante,lugares.get(lugarActual).getLugar()));
			contLugarActual++;
			contPartidos++;
			if(contLugarActual==lugares.get(lugarActual).getDisponibilidad()) {
				lugarActual++;
				contLugarActual=0;
			}
			if(contPartidos==partidosTemp.size()/divisor) {
				fecha=new Fecha(contFechas,partidos);
				fechas.add(fecha);
				for(Partido partido : partidos) {
					partido.setFecha(fecha);
				}
				partidos=new ArrayList<Partido>();
				contFechas++;
				contPartidos=0;
				contLugarActual=0;
				lugarActual=0;
			}
		}
		Fixture fixture=new Fixture(fechas,competencia);
		for(Fecha f : fechas) {
			f.setFixture(fixture);
		}
		if(competencia.getEstado()==EstadoCompetencia.PLANIFICADA) {
			competencia.setFixture(null);
		}

		return fixture;
	}
	static public class PartidoTemp
    {
        public Participante local, visitante;
    }
    private static List<PartidoTemp> calcularLigaNumEquiposPar(List<Participante> participantes){
    	int numRondas = participantes.size() - 1;
    	int numPartidosPorRonda = participantes.size() / 2;
    	PartidoTemp[][] rondas = new PartidoTemp[numRondas][numPartidosPorRonda];
    	for (int i=0,k=0;i<numRondas;i++){
            for (int j=0;j<numPartidosPorRonda;j++){
                rondas[i][j]=new PartidoTemp();
                rondas[i][j].local=participantes.get(k);
                k++;
                if (k==numRondas)
                    k=0;
            }
        }
        for (int i=0;i<numRondas;i++){
            if(i%2==0){
            	rondas[i][0].visitante = participantes.get(participantes.size()-1);
            	}
            else{
                rondas[i][0].visitante = rondas[i][0].local;
                rondas[i][0].local = participantes.get(participantes.size()-1);
            }
        }
        int equipoMasAlto = participantes.size()-1;
        int equipoImparMasAlto = equipoMasAlto-1;
        for (int i = 0, k = equipoImparMasAlto;i<numRondas;i++){
            for (int j=1;j<numPartidosPorRonda;j++){
                rondas[i][j].visitante = participantes.get(k);
                k--;
                if(k==-1)
                    k=equipoImparMasAlto;
            }
        }
        List<PartidoTemp> lista=new ArrayList<PartidoTemp>();
        for(int i=0;i<numRondas;i++) {
        	for(int j=0; j<numPartidosPorRonda;j++) {
        		lista.add(rondas[i][j]);
        	}
        }
        return lista;
    }
    private static List<PartidoTemp> calcularLigaNumEquiposImpar(List<Participante> participantes){
        int numRondas=participantes.size();
        int numPartidosPorRonda=(participantes.size())/2;
        PartidoTemp[][] rondas = new PartidoTemp[numRondas][numPartidosPorRonda];
        for(int i=0,k=0;i<numRondas;i++){
            for (int j = -1; j < numPartidosPorRonda; j ++){
                if (j>=0){
                    rondas[i][j] = new PartidoTemp();
                    rondas[i][j].local = participantes.get(k);
                    }
                k++;
                	if (k==numRondas)
                    k=0;
            }
        }
        int equipoMasAlto=participantes.size()-1;
        
        for(int i=0,k=equipoMasAlto;i<numRondas;i++){
        	for (int j=0;j<numPartidosPorRonda;j++){
                rondas[i][j].visitante = participantes.get(k);
                k--;
                if(k==-1)
                    k=equipoMasAlto;
        	}
        }
        List<PartidoTemp> lista=new ArrayList<PartidoTemp>();
        for(int i=0;i<numRondas;i++){
        	for(int j=0; j<numPartidosPorRonda;j++){
        		lista.add(rondas[i][j]);
        	}
        }
        return lista;
    }
    static public List<PartidoTemp> calcularPartidos(List<Participante> participantes){
    	if (participantes.size()%2==0)
        	return calcularLigaNumEquiposPar(participantes);
    	else
    		return calcularLigaNumEquiposImpar(participantes);
    }
	public static List<PartidoDTO> getProximosEncuentros(FixtureDTO fixtureDto) {
		Fixture fixture = FixtureDAO.getFixtureById(fixtureDto.getId_fixture());
		List<Partido> partidos = new ArrayList<>();
		List<PartidoDTO> retorno = new ArrayList<>();
		for(Fecha f : fixture.getListaFechas()) {
			partidos.addAll(f.getListaPartidos());
		}
		for(Partido p : partidos) {
			if(p.getResultado() == null) {
				retorno.add(new PartidoDTO(p.getParticipanteA(),p.getParticipanteB(),p.getFecha().getNumero()));
			}
		}
		return retorno;
	}
}
