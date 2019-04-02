/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.vulkan.model.IResourceContainer;
import org.sheepy.lily.vulkan.model.resource.AbstractConstants;
import org.sheepy.lily.vulkan.model.resource.DescriptorSet;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Pipeline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.AbstractPipeline#getUnits <em>Units</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.AbstractPipeline#getDescriptorSetRef <em>Descriptor Set Ref</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.AbstractPipeline#getDescriptorSet <em>Descriptor Set</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.AbstractPipeline#getConstants <em>Constants</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getAbstractPipeline()
 * @model abstract="true"
 * @generated
 */
public interface AbstractPipeline extends IPipeline, IResourceContainer
{
	/**
	 * Returns the value of the '<em><b>Units</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.process.IPipelineUnit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Units</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Units</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getAbstractPipeline_Units()
	 * @model containment="true"
	 * @generated
	 */
	EList<IPipelineUnit> getUnits();

	/**
	 * Returns the value of the '<em><b>Descriptor Set Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptor Set Ref</em>' reference.
	 * @see #setDescriptorSetRef(DescriptorSet)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getAbstractPipeline_DescriptorSetRef()
	 * @model
	 * @generated
	 */
	DescriptorSet getDescriptorSetRef();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.AbstractPipeline#getDescriptorSetRef <em>Descriptor Set Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Descriptor Set Ref</em>' reference.
	 * @see #getDescriptorSetRef()
	 * @generated
	 */
	void setDescriptorSetRef(DescriptorSet value);

	/**
	 * Returns the value of the '<em><b>Descriptor Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptor Set</em>' containment reference.
	 * @see #setDescriptorSet(DescriptorSet)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getAbstractPipeline_DescriptorSet()
	 * @model containment="true"
	 * @generated
	 */
	DescriptorSet getDescriptorSet();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.AbstractPipeline#getDescriptorSet <em>Descriptor Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Descriptor Set</em>' containment reference.
	 * @see #getDescriptorSet()
	 * @generated
	 */
	void setDescriptorSet(DescriptorSet value);

	/**
	 * Returns the value of the '<em><b>Constants</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constants</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constants</em>' reference.
	 * @see #setConstants(AbstractConstants)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getAbstractPipeline_Constants()
	 * @model
	 * @generated
	 */
	AbstractConstants getConstants();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.AbstractPipeline#getConstants <em>Constants</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constants</em>' reference.
	 * @see #getConstants()
	 * @generated
	 */
	void setConstants(AbstractConstants value);

} // AbstractPipeline
