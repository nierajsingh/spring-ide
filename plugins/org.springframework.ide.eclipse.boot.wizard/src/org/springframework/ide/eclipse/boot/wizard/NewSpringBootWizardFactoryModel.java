/*******************************************************************************
 * Copyright (c) 2017 Pivotal, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Pivotal, Inc. - initial API and implementation
 *******************************************************************************/
package org.springframework.ide.eclipse.boot.wizard;

import org.eclipse.jface.preference.IPreferenceStore;
import org.springframework.ide.eclipse.boot.core.BootActivator;
import org.springframework.ide.eclipse.boot.core.BootPreferences;
import org.springframework.util.StringUtils;
import org.springsource.ide.eclipse.commons.frameworks.core.downloadmanager.URLConnectionFactory;
import org.springsource.ide.eclipse.commons.livexp.core.AsyncLiveExpression;
import org.springsource.ide.eclipse.commons.livexp.core.LiveExpression;
import org.springsource.ide.eclipse.commons.livexp.core.LiveVariable;
import org.springsource.ide.eclipse.commons.livexp.core.StringFieldModel;
import org.springsource.ide.eclipse.commons.livexp.core.ValidationResult;
import org.springsource.ide.eclipse.commons.livexp.util.ExceptionUtil;

/**
 * A 'FactoryModelModel' for NewSpringBootWizardModel. I.e. this is a model for the NewSpringBootWizard
 * the dynamically creates a {@link NewSpringBootWizardModel} based on some 'static' inputs.
 *
 * @author Kris De Volder
 */
public class NewSpringBootWizardFactoryModel {

	public static InitializrFactoryModel<NewSpringBootWizardModel> create(URLConnectionFactory urlConnectionFactory, IPreferenceStore prefs) {
		return new InitializrFactoryModel<>((url) -> {
			if (StringUtils.hasText(url)) {
				return new NewSpringBootWizardModel(urlConnectionFactory, url, prefs);
			} else {
				throw new IllegalArgumentException("No URL entered");
			}
		});
	}

}