/**
 */
package org.sheepy.vulkan.model.pipeline;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Push Constant Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.pipeline.PushConstantRange#getStages <em>Stages</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.pipeline.PushConstantRange#getOffset <em>Offset</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.pipeline.PushConstantRange#getSize <em>Size</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.pipeline.PipelinePackage#getPushConstantRange()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface PushConstantRange extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Stages</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.enumeration.EShaderStage}.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EShaderStage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stages</em>' attribute list.
	 * @see org.sheepy.vulkan.model.enumeration.EShaderStage
	 * @see org.sheepy.vulkan.model.pipeline.PipelinePackage#getPushConstantRange_Stages()
	 * @model required="true"
	 * @generated
	 */
	EList<EShaderStage> getStages();

	/**
	 * Returns the value of the '<em><b>Offset</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset</em>' attribute.
	 * @see #setOffset(int)
	 * @see org.sheepy.vulkan.model.pipeline.PipelinePackage#getPushConstantRange_Offset()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getOffset();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.pipeline.PushConstantRange#getOffset <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset</em>' attribute.
	 * @see #getOffset()
	 * @generated
	 */
	void setOffset(int value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(int)
	 * @see org.sheepy.vulkan.model.pipeline.PipelinePackage#getPushConstantRange_Size()
	 * @model unique="false"
	 * @generated
	 */
	int getSize();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.pipeline.PushConstantRange#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(int value);

} // PushConstantRange
