/*******************************************************************************
 * Copyright (c) 2015, 2016 Pivotal, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Pivotal, Inc. - initial API and implementation
 *******************************************************************************/
package org.springframework.ide.eclipse.editor.support.yaml.reconcile;

import org.eclipse.core.runtime.IProgressMonitor;
import org.springframework.ide.eclipse.editor.support.yaml.ast.YamlFileAST;

public interface YamlASTReconciler {
	void reconcile(YamlFileAST ast, IProgressMonitor mon);
}
