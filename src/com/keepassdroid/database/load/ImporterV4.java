/*
 * Copyright 2009 Brian Pellin.
 *     
 * This file is part of KeePassDroid.
 *
 *  KeePassDroid is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  KeePassDroid is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with KeePassDroid.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package com.keepassdroid.database.load;

import java.io.IOException;
import java.io.InputStream;

import com.keepassdroid.UpdateStatus;
import com.keepassdroid.database.PwDatabaseV4;
import com.keepassdroid.database.PwDbHeaderV4;
import com.keepassdroid.database.exception.InvalidDBSignatureException;
import com.keepassdroid.database.exception.InvalidDBVersionException;
import com.keepassdroid.database.exception.InvalidKeyFileException;
import com.keepassdroid.database.exception.InvalidPasswordException;

public class ImporterV4 extends Importer {

	@Override
	public PwDatabaseV4 openDatabase(InputStream inStream, String password,
			String keyfile) throws IOException, InvalidKeyFileException,
			InvalidPasswordException, InvalidDBSignatureException, InvalidDBVersionException {

		return openDatabase(inStream, password, keyfile, new UpdateStatus());
	}
	
	@Override
	public PwDatabaseV4 openDatabase(InputStream inStream, String password,
			String keyfile, UpdateStatus status) throws IOException,
			InvalidKeyFileException, InvalidPasswordException,
			InvalidDBSignatureException, InvalidDBVersionException {

		
		PwDatabaseV4 db = new PwDatabaseV4();
		
		PwDbHeaderV4 header = new PwDbHeaderV4(db);
		
		header.loadFromFile(inStream);
		
		// Attach decryptor
		//if ( db.compressionAlgorithm == )
		
		return db;
	}


}
