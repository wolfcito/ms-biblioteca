package com.ceiba.biblioteca.util;

import java.util.Arrays;

import static com.ceiba.biblioteca.util.TipoUsuario.*;

public class TipoUsuarioUtils {

    private static final int  DAYS_USUARIO_AFILIAD0 = 10;
    private static final int  DAYS_USUARIO_EMPLEADO_BIBLIOTECA = 8;
    private static final int  DAYS_USUARIO_INVITADO = 7;

    public static int getDayPerUser(Integer codigoTipoUsuario ){
        int result = 0;

        if(codigoTipoUsuario == USUARIO_AFILIAD0.ordinal()){
            result = DAYS_USUARIO_AFILIAD0;
        }
        if(codigoTipoUsuario == USUARIO_EMPLEADO_BIBLIOTECA.ordinal()){
            result = DAYS_USUARIO_EMPLEADO_BIBLIOTECA;
        }
        if(codigoTipoUsuario == USUARIO_INVITADO.ordinal()){
            result = DAYS_USUARIO_INVITADO;
        }
        return result;
    }

    public static boolean ValidateUser(Integer codigoTipoUsuario){
        return Arrays.stream(TipoUsuario.values()).anyMatch(tpuser -> tpuser.ordinal() == codigoTipoUsuario);
    }

}
