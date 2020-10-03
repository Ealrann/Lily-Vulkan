/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.sheepy.lily.core.model.types.LNamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Pipeline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.AbstractPipeline#isAllocate <em>Allocate</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.AbstractPipeline#isRecord <em>Record</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.AbstractPipeline#getExtensionPkg <em>Extension Pkg</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getAbstractPipeline()
 * @model abstract="true"
 * @generated
 */
public interface AbstractPipeline extends LNamedElement
{
	/**
	 * Returns the value of the '<em><b>Allocate</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allocate</em>' attribute.
	 * @see #setAllocate(boolean)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getAbstractPipeline_Allocate()
	 * @model default="true" unique="false"
	 * @generated
	 */
	boolean isAllocate();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.AbstractPipeline#isAllocate <em>Allocate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allocate</em>' attribute.
	 * @see #isAllocate()
	 * @generated
	 */
	void setAllocate(boolean value);

	/**
	 * Returns the value of the '<em><b>Record</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Record</em>' attribute.
	 * @see #setRecord(boolean)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getAbstractPipeline_Record()
	 * @model default="true" unique="false"
	 * @generated
	 */
	boolean isRecord();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.AbstractPipeline#isRecord <em>Record</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Record</em>' attribute.
	 * @see #isRecord()
	 * @generated
	 */
	void setRecord(boolean value);

	/**
	 * Returns the value of the '<em><b>Extension Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension Pkg</em>' containment reference.
	 * @see #setExtensionPkg(PipelineExtensionPkg)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getAbstractPipeline_ExtensionPkg()
	 * @model containment="true"
	 * @generated
	 */
	PipelineExtensionPkg getExtensionPkg();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.AbstractPipeline#getExtensionPkg <em>Extension Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension Pkg</em>' containment reference.
	 * @see #getExtensionPkg()
	 * @generated
	 */
	void setExtensionPkg(PipelineExtensionPkg value);

} // AbstractPipeline
