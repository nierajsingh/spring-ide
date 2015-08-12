/*******************************************************************************
 * Copyright (c) 2015 Pivotal Software, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Pivotal Software, Inc. - initial API and implementation
 *******************************************************************************/
package org.springframework.ide.eclipse.boot.ui;

import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.springframework.ide.eclipse.boot.core.BootPropertyTester;

/**
 * Decorates a Spring Boot Project with a '[devtools]' text decoration if the
 * project has spring-boot-devtools as a dependency on its classpath.
 *
 * @author Kris De Volder
 */
public class BootProjectDecorator implements ILightweightLabelDecorator {

	public BootProjectDecorator() {
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
	}

	@Override
	public void dispose() {
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
	}

	@Override
	public void decorate(Object element, IDecoration decoration) {
		//System.out.println("Decorating "+element);
		IProject project = getProject(element);
//		decoration.setForegroundColor(Display.getDefault().getSystemColor(SWT.COLOR_MAGENTA));
		if (project!=null) {
			if (BootPropertyTester.isBootProject(project)) {
				decoration.addSuffix("[boot]");
				if (BootPropertyTester.hasDevtools(project)) {
					decoration.addSuffix("[devtools]");
				}
			}
		}
	}

	private IProject getProject(Object element) {
		if (element instanceof IProject) {
			return (IProject) element;
		} else if (element instanceof IJavaProject) {
			return ((IJavaProject) element).getProject();
		}
		return null;
	}


}
