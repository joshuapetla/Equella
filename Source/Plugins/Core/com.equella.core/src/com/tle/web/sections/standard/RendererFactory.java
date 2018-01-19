/*
 * Copyright 2017 Apereo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tle.web.sections.standard;

import java.util.Collection;
import java.util.List;

import com.tle.web.sections.SectionInfo;
import com.tle.web.sections.render.SectionRenderable;
import com.tle.web.sections.standard.model.HtmlComponentState;

/**
 * This class creates renderers based on a renderer name string, and a
 * {@link HtmlComponentState}.
 * 
 * @author jmaginnis
 */
public interface RendererFactory
{
	SectionRenderable getRenderer(SectionInfo info, HtmlComponentState state);

	SectionRenderable convertToRenderer(Object object);

	SectionRenderable convertToRenderer(Object... objects);

	SectionRenderable[] convertToRenderers(Object... objects);

	List<SectionRenderable> convertToRenderers(Collection<?> objects);
}