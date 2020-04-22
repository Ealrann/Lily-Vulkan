/**
 */
package org.sheepy.vulkan.model.graphicpipeline;

import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.vulkan.model.enumeration.EPrimitiveTopology;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Assembly</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.InputAssembly#isPrimitiveRestartEnabled <em>Primitive Restart Enabled</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.InputAssembly#getPrimitiveTopology <em>Primitive Topology</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getInputAssembly()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface InputAssembly extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Primitive Restart Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primitive Restart Enabled</em>' attribute.
	 * @see #setPrimitiveRestartEnabled(boolean)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getInputAssembly_PrimitiveRestartEnabled()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isPrimitiveRestartEnabled();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.InputAssembly#isPrimitiveRestartEnabled <em>Primitive Restart Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primitive Restart Enabled</em>' attribute.
	 * @see #isPrimitiveRestartEnabled()
	 * @generated
	 */
	void setPrimitiveRestartEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Primitive Topology</b></em>' attribute.
	 * The default value is <code>"TRIANGLE_LIST"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EPrimitiveTopology}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primitive Topology</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPrimitiveTopology
	 * @see #setPrimitiveTopology(EPrimitiveTopology)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getInputAssembly_PrimitiveTopology()
	 * @model default="TRIANGLE_LIST" unique="false"
	 * @generated
	 */
	EPrimitiveTopology getPrimitiveTopology();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.InputAssembly#getPrimitiveTopology <em>Primitive Topology</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primitive Topology</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPrimitiveTopology
	 * @see #getPrimitiveTopology()
	 * @generated
	 */
	void setPrimitiveTopology(EPrimitiveTopology value);

} // InputAssembly
