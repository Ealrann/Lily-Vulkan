/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.eclipse.emf.common.util.EList;

import org.sheepy.vulkan.model.enumeration.EShaderStage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Push Constant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.PushConstant#getStages <em>Stages</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getPushConstant()
 * @model abstract="true"
 * @generated
 */
public interface PushConstant extends IPipelineTask
{
	/**
	 * Returns the value of the '<em><b>Stages</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.enumeration.EShaderStage}.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EShaderStage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stages</em>' attribute list.
	 * @see org.sheepy.vulkan.model.enumeration.EShaderStage
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getPushConstant_Stages()
	 * @model required="true"
	 * @generated
	 */
	EList<EShaderStage> getStages();

} // PushConstant
