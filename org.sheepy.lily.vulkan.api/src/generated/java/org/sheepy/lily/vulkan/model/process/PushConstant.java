/**
 */
package org.sheepy.lily.vulkan.model.process;

import java.nio.ByteBuffer;
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
 *   <li>{@link org.sheepy.lily.vulkan.model.process.PushConstant#getData <em>Data</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getPushConstant()
 * @model
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

	/**
	 * Returns the value of the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' attribute.
	 * @see #setData(ByteBuffer)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getPushConstant_Data()
	 * @model unique="false" dataType="org.sheepy.lily.vulkan.model.resource.ByteBuffer"
	 * @generated
	 */
	ByteBuffer getData();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.PushConstant#getData <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' attribute.
	 * @see #getData()
	 * @generated
	 */
	void setData(ByteBuffer value);
} // PushConstant
