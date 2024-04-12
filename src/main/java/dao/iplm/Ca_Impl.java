package dao.iplm;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entity.Ca;

public interface Ca_Impl extends Remote {
	public Ca getCaTheoMa(String maCa) throws RemoteException;
}
