/**
 */
package org.sheepy.lily.vulkan.extra.nuklear.model;

import org.sheepy.lily.core.model.builder.Builder;

import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.resource.Font;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pipeline Builder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPipelineBuilder#getFont <em>Font</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPackage#getNuklearPipelineBuilder()
 * @model
 * @generated
 */
public interface NuklearPipelineBuilder extends Builder<GraphicsPipeline>
{

	/**
	 * Returns the value of the '<em><b>Font</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font</em>' containment reference.
	 * @see #setFont(Font)
	 * @see org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPackage#getNuklearPipelineBuilder_Font()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Font getFont();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPipelineBuilder#getFont <em>Font</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font</em>' containment reference.
	 * @see #getFont()
	 * @generated
	 */
	void setFont(Font value);
} // NuklearPipelineBuilder
