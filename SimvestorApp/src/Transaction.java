// Author: Joshua Choi
// Date:   05/26/2020
// Rev:    01
// Notes:  An Interface which contains the necessary methods for a Transaction

public interface Transaction extends Investment
{
	boolean isTransaction();
	String toStringTransaction();
}
