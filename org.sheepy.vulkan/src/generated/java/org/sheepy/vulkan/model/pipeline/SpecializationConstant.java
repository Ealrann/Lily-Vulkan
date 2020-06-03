/**
 */
package org.sheepy.vulkan.model.pipeline;

import org.sheepy.lily.core.api.model.ILilyEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specialization Constant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.pipeline.SpecializationConstant#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.pipeline.SpecializationConstant#getConstantId <em>Constant Id</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.pipeline.SpecializationConstant#getSize <em>Size</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.pipeline.PipelinePackage#getSpecializationConstant()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface SpecializationConstant extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.sheepy.vulkan.model.pipeline.PipelinePackage#getSpecializationConstant_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.pipeline.SpecializationConstant#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Constant Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constant Id</em>' attribute.
	 * @see #setConstantId(int)
	 * @see org.sheepy.vulkan.model.pipeline.PipelinePackage#getSpecializationConstant_ConstantId()
	 * @model
	 * @generated
	 */
	int getConstantId();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.pipeline.SpecializationConstant#getConstantId <em>Constant Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constant Id</em>' attribute.
	 * @see #getConstantId()
	 * @generated
	 */
	void setConstantId(int value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(int)
	 * @see org.sheepy.vulkan.model.pipeline.PipelinePackage#getSpecializationConstant_Size()
	 * @model unique="false"
	 * @generated
	 */
	int getSize();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.pipeline.SpecializationConstant#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(int value);

} // SpecializationConstant
