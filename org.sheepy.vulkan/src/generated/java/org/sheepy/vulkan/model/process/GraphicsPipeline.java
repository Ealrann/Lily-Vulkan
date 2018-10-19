/**
 */
package org.sheepy.vulkan.model.process;

import org.eclipse.emf.common.util.EList;
import org.sheepy.vulkan.model.resource.Shader;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graphics Pipeline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.GraphicsPipeline#getShaders <em>Shaders</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.process.ProcessPackage#getGraphicsPipeline()
 * @model abstract="true"
 * @generated
 */
public interface GraphicsPipeline extends AbstractPipeline
{
	/**
	 * Returns the value of the '<em><b>Shaders</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.resource.Shader}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shaders</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shaders</em>' reference list.
	 * @see org.sheepy.vulkan.model.process.ProcessPackage#getGraphicsPipeline_Shaders()
	 * @model
	 * @generated
	 */
	EList<Shader> getShaders();

} // GraphicsPipeline
