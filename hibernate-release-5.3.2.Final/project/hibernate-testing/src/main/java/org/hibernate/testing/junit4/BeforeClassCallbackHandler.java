/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.testing.junit4;

import org.junit.runners.model.Statement;

/**
 * @author Steve Ebersole
 */
public class BeforeClassCallbackHandler extends Statement {
	private final CustomRunner runner;
	private final Statement wrappedStatement;

	public BeforeClassCallbackHandler(CustomRunner runner, Statement wrappedStatement) {
		this.runner = runner;
		this.wrappedStatement = wrappedStatement;
	}

	@Override
	public void evaluate() throws Throwable {
		runner.getTestClassMetadata().performBeforeClassCallbacks( runner.getTestInstance() );
		wrappedStatement.evaluate();
	}
}
