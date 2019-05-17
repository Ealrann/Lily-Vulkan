/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bind Vertex Buffer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.BindVertexBuffer#getFirstBinding <em>First Binding</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.BindVertexBuffer#getVertexBindings <em>Vertex Bindings</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getBindVertexBuffer()
 * @model
 * @generated
 */
public interface BindVertexBuffer extends IPipelineTask
{
	/**
	 * Returns the value of the '<em><b>First Binding</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Binding</em>' attribute.
	 * @see #setFirstBinding(int)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getBindVertexBuffer_FirstBinding()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getFirstBinding();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.BindVertexBuffer#getFirstBinding <em>First Binding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Binding</em>' attribute.
	 * @see #getFirstBinding()
	 * @generated
	 */
	void setFirstBinding(int value);

	/**
	 * Returns the value of the '<em><b>Vertex Bindings</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.process.graphic.VertexBinding}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertex Bindings</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getBindVertexBuffer_VertexBindings()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<VertexBinding> getVertexBindings();

} // BindVertexBuffer
