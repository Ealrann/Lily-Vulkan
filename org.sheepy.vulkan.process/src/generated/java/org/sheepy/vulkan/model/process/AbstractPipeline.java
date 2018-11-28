/**
 */
package org.sheepy.vulkan.model.process;

import org.sheepy.vulkan.model.resource.DescriptorSet;
import org.sheepy.vulkan.model.resource.PushConstant;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Pipeline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.AbstractPipeline#getDescriptorSet <em>Descriptor Set</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.AbstractPipeline#getPushConstant <em>Push Constant</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.process.ProcessPackage#getAbstractPipeline()
 * @model abstract="true"
 * @generated
 */
public interface AbstractPipeline extends IPipeline
{
	/**
	 * Returns the value of the '<em><b>Descriptor Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Descriptor Set</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptor Set</em>' reference.
	 * @see #setDescriptorSet(DescriptorSet)
	 * @see org.sheepy.vulkan.model.process.ProcessPackage#getAbstractPipeline_DescriptorSet()
	 * @model
	 * @generated
	 */
	DescriptorSet getDescriptorSet();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.AbstractPipeline#getDescriptorSet <em>Descriptor Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Descriptor Set</em>' reference.
	 * @see #getDescriptorSet()
	 * @generated
	 */
	void setDescriptorSet(DescriptorSet value);

	/**
	 * Returns the value of the '<em><b>Push Constant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Push Constant</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Push Constant</em>' containment reference.
	 * @see #setPushConstant(PushConstant)
	 * @see org.sheepy.vulkan.model.process.ProcessPackage#getAbstractPipeline_PushConstant()
	 * @model containment="true"
	 * @generated
	 */
	PushConstant getPushConstant();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.AbstractPipeline#getPushConstant <em>Push Constant</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Push Constant</em>' containment reference.
	 * @see #getPushConstant()
	 * @generated
	 */
	void setPushConstant(PushConstant value);

} // AbstractPipeline
