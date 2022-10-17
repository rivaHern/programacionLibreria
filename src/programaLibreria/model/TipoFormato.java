package programaLibreria.model;

public enum TipoFormato {
	
		DIGITAL(0),IMPRESO (1);

		private int numTipoFormato;

		TipoFormato(int numTipoFormato){
			this.numTipoFormato = numTipoFormato;
		}

		public int numTipoFormato() {
			return numTipoFormato;
		}


}
